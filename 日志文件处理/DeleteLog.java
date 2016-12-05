package LogDeal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteLog {
	ArrayList<LogType> logs = null;
	private static Scanner input = new Scanner(System.in);
	public DeleteLog(ArrayList<LogType> logs) throws Exception {
		super();
		this.logs = logs;
		delete();
	}
	public void delete(){
		String filePath = "e:"+File.separator+"程序设计方法学实验"+File.separator+"chrom2000.log";
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		System.out.println("输入你要删除的日志记录的编号：");
		int num = input.nextInt();
		logs.remove(num-1);
		dealLog.saveLog(logs);
		System.out.println("成功删除第"+num+"记录");
	}
}
