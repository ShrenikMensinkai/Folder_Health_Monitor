package Model;

import java.util.Date;

public class ModelFile {
	protected String fileName;
	protected double fileSize;
	protected String fileType;
	protected long fileCreated;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFileCreated() {
		return fileCreated;
	}
	public void setFileCreated(long fileCreated) {
		this.fileCreated = fileCreated;
	}
	
}
