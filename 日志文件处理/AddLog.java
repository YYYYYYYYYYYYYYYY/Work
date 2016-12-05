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
		String filePath = "e:"+File.separator+"������Ʒ���ѧʵ��"+File.separator+"chrom2000.log";
		System.out.println("1");
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		System.out.println("������ʾ������־��¼��");
		System.out.println("������־��¼���ͣ�");
		int type = input.nextInt();
		input.nextLine();
		System.out.println("���������¼���û�����");
		String username = input.nextLine();
		System.out.println("��¼ʱ��ֱ�Ӷ�ȡϵͳʱ��");
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String data = dFormat.format(new java.util.Date());
		System.out.println("������¼��ʱ��Ϊ��"+data);
		System.out.println("���������¼����ϸ��Ϣ��");
		String news = input.nextLine();
		int usernameLength = username.getBytes("gbk").length;
		int dateLength = data.getBytes("gbk").length;
		int newsLength = news.getBytes("gbk").length;
		LogType newLog = new LogType(type, usernameLength, username, dateLength, data, newsLength, news);
		logs.add(newLog);
		System.out.println("�ɹ������־��"+newLog.toString());
		dealLog.saveLog(logs);
	}
}
