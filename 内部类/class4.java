package innerClass;

public class class4 {
	public static void main(String[] args) {
	Interface i = new Interface(){
		public void print(){
			System.out.println("使用了匿名内部类");
		}
	};
	i.print();
}
}
