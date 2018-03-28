package Services;

import java.util.ArrayList;

import Model.ModelFile;
import Services.FileService;
import ServicesInterface.ExecutionServiceInterface;

public class ExecutionService implements ExecutionServiceInterface  {
	FileService fs = new FileService();
	ArrayList<ModelFile> tempFiles = new ArrayList<ModelFile>();
	ArrayList<ModelFile> deleteFiles = new ArrayList<ModelFile>();
	ArrayList<ModelFile> filesToMove = new ArrayList<ModelFile>();
	double MAXSIZE = 100;
	double tempSize;
	@Override
	public boolean fileHealthMonitor(String[] batchFiles, String src, String dest) {
		try{
			if(src==null || dest==null){
				System.out.println("FileSource or FileDestination cannot be null");
				return false;
			}
			tempFiles=fs.readFiles(src);
			deleteFiles =fs.getBatchFiles(tempFiles,batchFiles);
			fs.deleteBatchFiles(deleteFiles,src);
			tempFiles=fs.readFiles(src);
			tempSize=fs.getFolderSize(tempFiles);
			if(tempSize>MAXSIZE){
				tempFiles=fs.sortFilesCreateDate(tempFiles);
				filesToMove = fs.fileToMove(tempFiles,tempSize-MAXSIZE);
				fs.moveFiles(filesToMove, src, dest);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return false;
	}
	
	
}
