package TestService;


import Services.ExecutionService;


public class TestService {

	public static void main(String[] args) {
		ExecutionService es = new ExecutionService(); 
		String sourceFolder = "/home/om/test_input/";
		String destinationFolder = "/home/om/test_output/"; 
		String reportFilePath = "/home/om/report/";
		String[] batchExtenction ={"sh","bat","odt"}; // File Extensions that are not allowed
		double MAXSIZE = 100000; // Max size of Secured Folder 100mb (100000kb)
		int TIMEDELAY = 300000; // 5 Mins in ms
		
		for(;;){
			es.fileHealthMonitor(batchExtenction, sourceFolder, destinationFolder,MAXSIZE,reportFilePath);
//			System.out.println("s");
			try {
				Thread.sleep(TIMEDELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
