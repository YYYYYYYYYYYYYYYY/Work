package LogDeal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class ReadLog {
	private ArrayList<LogType> logs = null;
	private static Scanner input = new Scanner(System.in);
	public ReadLog(ArrayList<LogType> logs) throws Exception {
		super();
		this.logs = logs;
		read();
	}
	public void read(){
		String filePath = "e:"+File.separator+"������Ʒ���ѧʵ��"+File.separator+"chrom2000.log";
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		System.out.println("��ѡ����Ҫ��ȡ����־��¼�ı�ţ�");
		int num = input.nextInt();
		System.out.println(num+"\t"+logs.get(num-1).toString());
	}
}
