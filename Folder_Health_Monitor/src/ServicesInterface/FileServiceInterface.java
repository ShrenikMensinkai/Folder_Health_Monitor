package ServicesInterface;

import java.io.BufferedWriter;
import java.util.ArrayList;

import Model.ModelFile;
import Model.ModelReport;

public interface FileServiceInterface {
	public ArrayList<ModelFile> readFiles(String path);
	public double getFolderSize(ArrayList<ModelFile> filesList);
	public ArrayList<ModelFile> sortFilesCreateDate(ArrayList<ModelFile> filesList);
	public ArrayList<ModelFile> swapFiles(ArrayList<ModelFile> filesList, int j, int i);
	public boolean deleteBatchFiles(ArrayList<ModelFile> filesList,String path);
	public ArrayList<ModelFile> getBatchFiles(ArrayList<ModelFile> filesList, String[] batchFiles);
	public ArrayList<ModelFile> fileToMove(ArrayList<ModelFile> filesList, double size);
	public ArrayList<ModelFile> moveFiles(ArrayList<ModelFile> filesList, String sourcePath,String destinationPath);
	public void writeReportToTextfile(ModelReport reportFile,BufferedWriter bw);
	public String createDeleteFileString(ArrayList<ModelFile> modelFiles);
}
