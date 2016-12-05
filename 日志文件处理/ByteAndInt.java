package LogDeal;

public class ByteAndInt {
	//��byte��ת��Ϊint�ͣ������ڶ�ȡ��־�ļ�ʱ�õ���
	public int byteToInt(byte[] bytes) {
		int  targets = (bytes[0] & 0xff) | ((bytes[1] << 8) & 0xff00)  
				| ((bytes[2] << 24) >>> 8) | (bytes[3] << 24);
		return targets;
	}
	//��int��ת��Ϊbyte�ͣ����Ǳ�����־�ļ�ʱ�õ���
	public static byte[] intToByte(int ints) {
		byte[] targets = new byte[4];  
		targets[0] = (byte) (ints & 0xff);// ���λ   
		targets[1] = (byte) ((ints >> 8) & 0xff);// �ε�λ   
		targets[2] = (byte) ((ints >> 16) & 0xff);// �θ�λ   
		targets[3] = (byte) (ints >>> 24);// ���λ,�޷������ơ�
		
		return targets;
	}
}
