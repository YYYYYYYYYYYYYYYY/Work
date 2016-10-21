package john.Exception;

class Math{
	public void div(int i,int j)throws Exception{
		System.out.println("开始计算：");
		int temp = 0;
		try {
			temp = i/j;
			System.out.println("结果为："+temp);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			System.out.println("是否出现异常都会执行此语句");
			System.out.println("计算结束");
		}
	}
}

public class ExceptionClass2 {
	public static void main(String[] args) {
		Math math = new Math();
		try {
			math.div(100, 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("捕获到异常："+e);
		}
	}
}
