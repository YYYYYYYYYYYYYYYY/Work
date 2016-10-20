package innerClass;

public class class3 {
	private String info = "使用了局部内部类";
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
