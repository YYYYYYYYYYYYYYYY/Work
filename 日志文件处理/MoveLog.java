package LogDeal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MoveLog {
	private ArrayList<LogType> logs = null;
	private static Scanner input = new Scanner(System.in);
	public MoveLog(ArrayList<LogType> logs) throws Exception {
		super();
		this.logs = logs;
		move();
	}
	public void move(){
		System.out.println("请输入你要移动的日志记录的编号：");
		int num1 = input.nextInt();
		System.out.println("请输入你要将第"+num1+"条记录移动到的位置的编号：");
		int num2 = input.nextInt();
		String filePath = "e:"+File.separator+"程序设计方法学实验"+File.separator+"chrom2000.log";
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		LogType log1 = logs.get(num1-1);
		logs.remove(num1-1);
		logs.add(num2-1, log1);
		dealLog.saveLog(logs);
		System.out.println("成功将第"+num1+"条记录移动到第"+num2+"记录处");
	}
}
