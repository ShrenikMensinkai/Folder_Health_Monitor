package Model;

import java.text.SimpleDateFormat;


public class ModelReport {
	protected String dateTime;
	protected double folderSizeBefore;
	protected double folderSizeAfter;;
	protected long archivedFileCount ;
	protected String deletedFileName;
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public double getFolderSizeBefore() {
		return folderSizeBefore;
	}
	public void setFolderSizeBefore(double folderSizeBefore) {
		this.folderSizeBefore = folderSizeBefore;
	}
	public double getFolderSizeAfter() {
		return folderSizeAfter;
	}
	public void setFolderSizeAfter(double folderSizeAfter) {
		this.folderSizeAfter = folderSizeAfter;
	}
	public long getArchivedFileCount() {
		return archivedFileCount;
	}
	public void setArchivedFileCount(long archivedFileCount) {
		this.archivedFileCount = archivedFileCount;
	}
	public String getDeleatedFileName() {
		return deletedFileName;
	}
	public void setDeletedFileName(String deleatedFileName) {
		this.deletedFileName = deleatedFileName;
	}

}
