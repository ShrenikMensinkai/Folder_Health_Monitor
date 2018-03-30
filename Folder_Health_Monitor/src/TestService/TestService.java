package TestService;


import java.text.SimpleDateFormat;

import Services.ExecutionService;


public class TestService {

	public static void main(String[] args) {
		ExecutionService es = new ExecutionService(); 
//		String sourceFolder = "/home/shrenik/test_input/";
//		String destinationFolder = "/home/shrenik/test_output/"; 
//		String reportFilePath = "/home/shrenik/report.txt";
//		
		String sourceFolder = "C:\\Target\\Secured\\";
		String destinationFolder = "C:\\Target\\Archived\\"; 
		String reportFilePath = "C:\\Target\\Report.txt";
		
		String[] batchExtenction ={"sh","bat","odt","doc"}; // File Extensions that are not allowed
		double MAXSIZE = 100000; // Max size of Secured Folder 100mb (100000kb)
//		int TIMEDELAY = 300000; // 5 Mins in ms
		int TIMEDELAY = 10000; // 5 sec
		
		
		for(;;){
			es.fileHealthMonitor(batchExtenction, sourceFolder, destinationFolder,MAXSIZE,reportFilePath);
//			System.out.println("Test");
			try {
				Thread.sleep(TIMEDELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
