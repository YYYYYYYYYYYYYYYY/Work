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
		System.out.println("��������Ҫ�ƶ�����־��¼�ı�ţ�");
		int num1 = input.nextInt();
		System.out.println("��������Ҫ����"+num1+"����¼�ƶ�����λ�õı�ţ�");
		int num2 = input.nextInt();
		String filePath = "e:"+File.separator+"������Ʒ���ѧʵ��"+File.separator+"chrom2000.log";
		DealLog dealLog = new DealLog(filePath);
		logs = dealLog.getLogs();
		LogType log1 = logs.get(num1-1);
		logs.remove(num1-1);
		logs.add(num2-1, log1);
		dealLog.saveLog(logs);
		System.out.println("�ɹ�����"+num1+"����¼�ƶ�����"+num2+"��¼��");
	}
}
