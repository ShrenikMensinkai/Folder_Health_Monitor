package Services;

import java.util.ArrayList;

import Model.ModelFile;
import Services.FileService;
import ServicesInterface.ExecutionServiceInterface;

public class ExecutionService implements ExecutionServiceInterface  {
	FileService fs = new FileService();
	ArrayList<ModelFile> tempFiles = new ArrayList<ModelFile>();
	ArrayList<ModelFile> filesToDelete = new ArrayList<ModelFile>();
	ArrayList<ModelFile> filesToMove = new ArrayList<ModelFile>();
	double tempSize;
	@Override
	public boolean fileHealthMonitor(String[] batchFiles, String src, String dest,double MAXSIZE) {
		try{
			if(src==null || dest==null){
				System.out.println("FileSource or FileDestination cannot be null");
				return false;
			}
			System.out.println(src);
			tempFiles=fs.readFiles(src); //Read Files from Secured folder
			
			filesToDelete =fs.getBatchFiles(tempFiles,batchFiles); //Check for batchfile exist in Secured folder
			if(!filesToDelete.isEmpty()){
				fs.deleteBatchFiles(filesToDelete,src);// Delete batch files from Secured folder
				tempFiles=fs.readFiles(src); 
			}
			tempSize=fs.getFolderSize(tempFiles); // Get Secured folder size
			if(tempSize>MAXSIZE){ // Check Secured folder size exceeding Maxsize
				tempFiles=fs.sortFilesCreateDate(tempFiles); //Sort Secured folder files on its creation date 
				filesToMove = fs.fileToMove(tempFiles,tempSize-MAXSIZE); //Get Files to move to Archive folder
				fs.moveFiles(filesToMove, src, dest); // Move to Archive folder
			} 
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}
	
	
}
