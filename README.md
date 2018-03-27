# Folder_Health_Monitor

Java program to monitor the health of folder called ‘secured’.
Monitoring includes folder size should not exceed 100 MB, archive
older files to another folder called ‘archive’ if entire file size exceeds
100 MB but it should retain latest files (upto 100 MB) in ‘secured’ folder
and also perform auto-delete of any executable (like .bat or .sh) which
are placed in ‘secured’ folder.

Input:
1) Read files from ‘temp’ folder and write into ‘secured’ folder
2) Multiple files to be copied in ‘secured’ folder in window of every 2
minutes

Output:
- Monitoring Scheduler should run on 5 every minutes
- Performs above operation and shows report of current size of
secured folder, any files archived, count of archived files if any
and deleted file names if any.
