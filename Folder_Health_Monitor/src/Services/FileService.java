package Services;

import java.util.ArrayList;
import java.io.File;
import Model.ModelFile;
import ServicesInterface.FileServiceInterface;

public class FileService implements FileServiceInterface {

	@Override
	public ArrayList<ModelFile> readFiles(String path) {
		ArrayList<ModelFile> tempFiles = new ArrayList<ModelFile>(); 
		try{
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					ModelFile tempFile = new ModelFile();
					String fileName = listOfFiles[i].getName();
					String[] nameSplit = fileName.split("\\.");
					tempFile.setFileName(listOfFiles[i].getName());
					tempFile.setFileSize(listOfFiles[i].length());
					tempFile.setFileCreated(listOfFiles[i].lastModified());
					tempFile.setFileType(nameSplit[1]);
					tempFiles.add(tempFile);
				} else if (listOfFiles[i].isDirectory()) {
			        System.out.println("Directory " + listOfFiles[i].getName());
		    	}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}return tempFiles;
	}

	@Override
	public double getFolderSize(ArrayList<ModelFile> filesList) {
		double folderSize=0;
		for (ModelFile modelFile : filesList) {
			folderSize+= modelFile.getFileSize();
		}
		return folderSize;
	}

}
