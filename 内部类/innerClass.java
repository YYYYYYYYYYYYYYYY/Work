package innerClass;

class out{
	private static String info = "ʹ���˾�̬�ڲ���";
	
	static class In{
		public void print(){
			System.out.println(info);
		}
	}
}
public class innerClass {
	public static void main(String[] args) {
		new out.In().print();
	}
}
