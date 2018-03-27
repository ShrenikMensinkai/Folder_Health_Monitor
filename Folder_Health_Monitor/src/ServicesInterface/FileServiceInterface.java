package ServicesInterface;

import java.util.ArrayList;

import Model.ModelFile;

public interface FileServiceInterface {
	public ArrayList<ModelFile> readFiles(String path);
	public double getFolderSize(ArrayList<ModelFile> filesList);

}
