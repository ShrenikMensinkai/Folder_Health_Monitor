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

	@Override
	public ArrayList<ModelFile> sortFilesCreateDate(ArrayList<ModelFile> filesList) {
		for(int i=0;i<filesList.size()-1;i++){
			for(int j=0;j<filesList.size()-2;j++){
				if(filesList.get(j).getFileCreated() > filesList.get(j+1).getFileCreated()){
					filesList= swapOrders(filesList,j,j+1);
				}
			}
		}return filesList;
		
	}

	@Override
	public ArrayList<ModelFile> swapOrders(ArrayList<ModelFile> filesList, int fileIndexI, int fileIndexJ) {
		ModelFile temp1=null;
		ModelFile temp2=null;
		temp1=filesList.get(fileIndexI);
		temp2=filesList.get(fileIndexJ);
		filesList.set(fileIndexI, temp2);
		filesList.set(fileIndexJ, temp1);
		return filesList;
	}



}
