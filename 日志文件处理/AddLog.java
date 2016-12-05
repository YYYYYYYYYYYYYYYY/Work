package LogDeal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class AddLog {
	private ArrayList<LogType> logs = null;
	private static Scanner input = new Scanner(System.in);
	public AddLog(ArrayList<LogType> logs) throws Exception {
		super();
		this.logs = logs;
		add();
	}
	public void add() throws Exception{
		String filePath = "e:"+File.separator+"程序设计方法学实验"+File.separator+"chrom2000.log";
		System.out.println("1");
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		System.out.println("根据提示输入日志记录：");
		System.out.println("输入日志记录类型：");
		int type = input.nextInt();
		input.nextLine();
		System.out.println("输入该条记录的用户名：");
		String username = input.nextLine();
		System.out.println("记录时间直接读取系统时间");
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String data = dFormat.format(new java.util.Date());
		System.out.println("该条记录的时间为："+data);
		System.out.println("输入该条记录的详细信息：");
		String news = input.nextLine();
		int usernameLength = username.getBytes("gbk").length;
		int dateLength = data.getBytes("gbk").length;
		int newsLength = news.getBytes("gbk").length;
		LogType newLog = new LogType(type, usernameLength, username, dateLength, data, newsLength, news);
		logs.add(newLog);
		System.out.println("成功添加日志："+newLog.toString());
		dealLog.saveLog(logs);
	}
}
