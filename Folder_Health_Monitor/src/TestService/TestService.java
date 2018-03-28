package TestService;

import java.io.File;
import java.util.ArrayList;

import Services.FileService;
import Model.ModelFile;

public class TestService {

	public static void main(String[] args) {
		FileService fs = new FileService(); 
		String sourceFolder = "/home/om/test_input/";
		String destinationFolder = "/home/om/test_output/"; 
		ArrayList<ModelFile> mf = new ArrayList<ModelFile>();
		ArrayList<ModelFile> batchFile = new ArrayList<ModelFile>();
		String[] batchExtenction ={"sh","bat","odt"};
		double folderSize =0;
		mf =fs.readFiles(sourceFolder);
		folderSize=fs.getFolderSize(mf);
		System.out.println(folderSize);
		
//		for (ModelFile modelFile : mf) {
//			System.out.println(modelFile.getFileName());
//			System.out.println(modelFile.getFileSize());
//			System.out.println(modelFile.getFileType());
//			System.out.println(modelFile.getFileCreated());
//		}
		batchFile = fs.getBatchFiles(mf,batchExtenction);
//		fs.deleteBatchFiles(batchFile,folderPath);
//		for (ModelFile modelFile : batchFile) {
//			System.out.println(modelFile.getFileName());
//			System.out.println(modelFile.getFileSize());
//			System.out.println(modelFile.getFileType());
//			System.out.println(modelFile.getFileCreated());
//		}

	    fs.moveFiles(batchFile,sourceFolder,destinationFolder);
	    
        
	}
}
