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
		String filePath = "e:"+File.separator+"������Ʒ���ѧʵ��"+File.separator+"chrom2000.log";
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		System.out.println("������Ҫɾ������־��¼�ı�ţ�");
		int num = input.nextInt();
		logs.remove(num-1);
		dealLog.saveLog(logs);
		System.out.println("�ɹ�ɾ����"+num+"��¼");
	}
}
