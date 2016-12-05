package LogDeal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DealLog {
	private File file = null;
	private String filePath;
 	private ArrayList<LogType> logs = new ArrayList<>();
	private ByteAndInt byteAndInt = new ByteAndInt();
	private int number = 0;
	public ArrayList<LogType> getLogs() {
		return logs;
	}
	public void setLogs(ArrayList<LogType> logs) {
		this.logs = logs;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public DealLog(String filePath){
		super();
		this.filePath = filePath;
		file = new File(filePath);
		getLog();
	}
	public void getLog() {
		FileInputStream fInputStream = null;
		//读取日志头
		try {
			fInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] gLog = new byte[4];
		try {
			fInputStream.read(gLog);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		number = byteAndInt.byteToInt(gLog);//此时number为该日志文件的日志记录个数
		//循环读取日志记录
		for (int i = 0; i < number; i++) {
			//读取该条日志记录的类型
			try {
				fInputStream.read(gLog);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int type = byteAndInt.byteToInt(gLog);
			//读取用户名长度及用户名
			try {
				fInputStream.read(gLog);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int usernameLength = byteAndInt.byteToInt(gLog);
			byte[] gUsername = new byte[usernameLength];
			try {
				fInputStream.read(gUsername);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String username = new String(gUsername);
			//读取时间长度及时间
			try {
				fInputStream.read(gLog);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int dateLength = byteAndInt.byteToInt(gLog);
			byte[] gDate = new byte[dateLength];
			try {
				fInputStream.read(gDate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String date = new String(gDate);
			//读取信息长度及信息
			try {
				fInputStream.read(gLog);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int newsLength = byteAndInt.byteToInt(gLog);
			byte[] gNews = new byte[newsLength];
			try {
				fInputStream.read(gNews);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String news = new String(gNews);
			//输出整条日志记录
			LogType log = new LogType(type, usernameLength, username, dateLength, date, newsLength, news);
			logs.add(log);
		}
	}
	public void  saveLog(ArrayList<LogType> logs){
		FileOutputStream fOutputStream = null;
		try {
			fOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		number = logs.size();
		try {
			fOutputStream.write(byteAndInt.intToByte(number));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (LogType log : logs) {
			try{
				fOutputStream.write(byteAndInt.intToByte(log.getType()));
				fOutputStream.write(byteAndInt.intToByte(log.getUsernameLength()));
				fOutputStream.write(log.getUsername().getBytes("gbk"));
				fOutputStream.write(byteAndInt.intToByte(log.getDateLength()));
				fOutputStream.write(log.getDate().getBytes("gbk"));
				fOutputStream.write(byteAndInt.intToByte(log.getNewsLength()));
				fOutputStream.write(log.getNews().getBytes("gbk"));
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
