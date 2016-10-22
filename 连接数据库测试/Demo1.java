package john.MySQLTest;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) throws Exception{
		Connection conn = null;
		String sql;
		String url = "jdbc:mysql://localhost:3306/students_db?"
				+"user=root&password=yyyy&useUnicode=true&characterEncoding=utf-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			conn = DriverManager.getConnection(url);
			Statement stat = conn.createStatement();
			sql = "create table student(NO char(20),name varchar(20), primary key(NO))"
					+ "charset utf8 collate utf8_general_ci";
			int result = stat.executeUpdate(sql);
			if (result != -1) {
				System.out.println("创建数据表成功");
				sql = "insert into student(NO,name) values('2014001','陶伟基')";
				result = stat.executeUpdate(sql);
				sql = "insert into student(NO,name) values('2014002','周小俊')";
				result = stat.executeUpdate(sql);
				sql = "select * from student";
				ResultSet rs = stat.executeQuery(sql);
				System.out.println("学号\t姓名");
				while (rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getString(2));
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现错误");
			e.printStackTrace();
		}finally {
			System.out.println("helloWord");
		}
	}
}
