package TestService;

import java.io.File;
import java.util.ArrayList;

import Services.FileService;
import Model.ModelFile;

public class TestService {

	public static void main(String[] args) {
		FileService fs = new FileService(); 
		ArrayList<ModelFile> mf = new ArrayList<ModelFile>();
		double folderSize =0;
		mf =fs.readFiles("C:\\Target");
		folderSize=fs.getFolderSize(mf);
		System.out.println(folderSize);
		
		for (ModelFile modelFile : mf) {
			System.out.println(modelFile.getFileName());
			System.out.println(modelFile.getFileSize());
			System.out.println(modelFile.getFileType());
			System.out.println(modelFile.getFileCreated());
		}

	}
}
