package innerClass;

public class class3 {
	private String info = "ʹ���˾ֲ��ڲ���";
	public void output(){
		class Inner{
			public void print(){
				System.out.println(info);
			}
		};
		new Inner().print();
	}
	public static void main(String[] args) {
		new Outer().output();
	}
}
