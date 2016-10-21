package john.Exception;

public class ExceptionClass1 {
	public static void main(String[] args) {
		System.out.println("进行一个除数为零的除法运算来验证java异常捕获机制");
		int i = 100;
		int j = 0;
		try {
			int temp = i / j;
			System.out.println("计算结果为："+temp);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常："+e);
		}finally{
			System.out.println("是否出现异常都会执行该语句");
		}
	}
}
