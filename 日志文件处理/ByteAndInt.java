package LogDeal;

public class ByteAndInt {
	//从byte型转换为int型，这是在读取日志文件时用到的
	public int byteToInt(byte[] bytes) {
		int  targets = (bytes[0] & 0xff) | ((bytes[1] << 8) & 0xff00)  
				| ((bytes[2] << 24) >>> 8) | (bytes[3] << 24);
		return targets;
	}
	//从int型转换为byte型，这是保存日志文件时用到的
	public static byte[] intToByte(int ints) {
		byte[] targets = new byte[4];  
		targets[0] = (byte) (ints & 0xff);// 最低位   
		targets[1] = (byte) ((ints >> 8) & 0xff);// 次低位   
		targets[2] = (byte) ((ints >> 16) & 0xff);// 次高位   
		targets[3] = (byte) (ints >>> 24);// 最高位,无符号右移。
		
		return targets;
	}
}
