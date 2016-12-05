package LogDeal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	private static Scanner input = new Scanner(System.in);
	static String filePath = "e:"+File.separator+"������Ʒ���ѧʵ��"+File.separator+"chrom2000.log";
	private static DealLog dealLog = new DealLog(filePath);
	private static ArrayList<LogType> logs = dealLog.getLogs();
	public static void main(String[] args) throws Exception{
		System.out.println("��־����ϵͳ��");
		while (true) {
			System.out.println("1.��ȡ��־");
			System.out.println("2.ɾ����־");
			System.out.println("3.�ƶ���־");
			System.out.println("4.�����־");
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
