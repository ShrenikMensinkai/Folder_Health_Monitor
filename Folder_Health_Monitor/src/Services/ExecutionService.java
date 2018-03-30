package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.ModelFile;
import Model.ModelReport;
import Services.FileService;
import ServicesInterface.ExecutionServiceInterface;

public class ExecutionService implements ExecutionServiceInterface  {
	FileService fs = new FileService();
	ArrayList<ModelFile> tempFiles;
	ArrayList<ModelFile> filesToDelete;
	ArrayList<ModelFile> filesToMove;
	FileWriter fileWriter=null;
	BufferedWriter bufferedWriter=null;
	ModelReport tempReport;
	double tempSize;
	Date date;
	
	SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	@Override
	public boolean fileHealthMonitor(String[] batchFiles, String src, String dest,double MAXSIZE ,String reportPath) {
		try{
			tempReport = null;
			filesToMove = null;
			filesToDelete = null;
			tempFiles = null;
			fileWriter = null;
			bufferedWriter = null;
			date = null;
			
			filesToMove = new ArrayList<ModelFile>();
			filesToDelete = new ArrayList<ModelFile>();
			tempFiles = new ArrayList<ModelFile>();
			fileWriter = new FileWriter(reportPath,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			tempReport = new ModelReport();
			 
			date = new Date();
			tempReport.setDateTime(time.format(date));
			
			if(src==null || dest==null){
				System.out.println("FileSource or FileDestination cannot be null");
				return false;
			}
			
			tempFiles=fs.readFiles(src); //Read Files from Secured folder
			tempReport.setFolderSizeBefore(fs.getFolderSize(tempFiles));
			filesToDelete =fs.getBatchFiles(tempFiles,batchFiles); //Check for batchfile exist in Secured folder
			
			if(!filesToDelete.isEmpty()){
				fs.deleteBatchFiles(filesToDelete,src);// Delete batch files from Secured folder
				tempReport.setDeletedFileName(fs.createDeleteFileString(filesToDelete)); 
				tempFiles=fs.readFiles(src); 				
			}			
			tempSize=fs.getFolderSize(tempFiles); // Get Secured folder size
			
			if(tempSize>MAXSIZE){ // Check Secured folder size exceeding Maxsize
				tempFiles=fs.sortFilesCreateDate(tempFiles); //Sort Secured folder files on its creation date 
				filesToMove = fs.fileToMove(tempFiles,tempSize-MAXSIZE); //Get Files to move to Archive folder
				fs.moveFiles(filesToMove, src, dest); // Move to Archive folder
				tempReport.setArchivedFileCount(filesToMove.size());
//				filesToMove=null;
			} 
			
			
			tempReport.setFolderSizeAfter(fs.getFolderSize(fs.readFiles(src)));
			fs.writeReportToTextfile(tempReport,bufferedWriter); // Generate Report
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
}
