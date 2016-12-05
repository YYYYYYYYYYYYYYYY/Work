package LogDeal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	private static Scanner input = new Scanner(System.in);
	static String filePath = "e:"+File.separator+"程序设计方法学实验"+File.separator+"chrom2000.log";
	private static DealLog dealLog = new DealLog(filePath);
	private static ArrayList<LogType> logs = dealLog.getLogs();
	public static void main(String[] args) throws Exception{
		System.out.println("日志处理系统：");
		while (true) {
			System.out.println("1.读取日志");
			System.out.println("2.删除日志");
			System.out.println("3.移动日志");
			System.out.println("4.添加日志");
			int gInput = input.nextInt();
			switch (gInput) {
			case 1:
				ReadLog readLog = new ReadLog(logs);
				break;
			case 2:
				DeleteLog deleteLog = new DeleteLog(logs);
				break;
			case 3:
				MoveLog moveLog = new MoveLog(logs);
				break;
			case 4:
				AddLog addLog = new AddLog(logs);
				break;
			default:
				break;
			}
		}
	}
}
