package innerClass;

class Outer{
	private String info = "使用了非静态内部类";
	class Inner{
		public void print(){
			System.out.println(info);
		}
	}
	public void output(){
		new Inner().print();
	}
}

public class class2 {
	public static void main(String[] args) {
		new Outer().output();
	}
}
