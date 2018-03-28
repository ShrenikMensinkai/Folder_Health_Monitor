package ServicesInterface;

import java.util.ArrayList;

import Model.ModelFile;

public interface FileServiceInterface {
	public ArrayList<ModelFile> readFiles(String path);
	public double getFolderSize(ArrayList<ModelFile> filesList);
	public ArrayList<ModelFile> sortFilesCreateDate(ArrayList<ModelFile> filesList);
	public ArrayList<ModelFile> swapOrders(ArrayList<ModelFile> filesList, int j, int i);
	public ArrayList<ModelFile> deleteBatchFiles(ArrayList<ModelFile> filesList, String[] batchFiles);
}
