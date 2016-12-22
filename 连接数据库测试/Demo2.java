package john.MySQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo2 {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/students_db";
	public static final String DBUSER = "root";
	public static final String DBPASS = "yyyy";
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		String sql;
		
		//查
		System.out.println("查询数据操作：");
		sql = "select * from student";
		pStatement = conn.prepareStatement(sql);
		resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			String no = resultSet.getString("NO");
			String name = resultSet.getString("Name");
			System.out.print("NO:"+no+"\t");
			System.out.println("Name:"+name);
		}
		System.out.println("***********************");
		
		//增
		System.out.println();
		System.out.println("增加数据操作：");
		sql = "insert into student(No,Name) values(?,?)";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, "2014004");
		pStatement.setString(2, "john");
		pStatement.executeUpdate();
		System.out.println("查询增加后的数据：");
		sql = "select * from student where no = ?";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, "2014004");
		resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			String no = resultSet.getString(1);
			String name = resultSet.getString(2);
			System.out.print("NO:"+no+"\t");
			System.out.println("Name:"+name);
		}
		System.out.println("***********************");
		
		//改
		System.out.println();
		System.out.println("修改数据操作：");
		sql = "update student set name = ? where no = ?";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, "YY");
		pStatement.setString(2, "2014004");
		pStatement.executeUpdate();
		System.out.println("查询修改数据后的数据表：");
		sql = "select * from student";
		pStatement = conn.prepareStatement(sql);
		resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			String no = resultSet.getString(1);
			String name = resultSet.getString(2);
			System.out.print("NO:"+no+"\t");
			System.out.println("Name:"+name);
		}
		System.out.println("***********************");
		
		//删
		System.out.println();
		System.out.println("删除数据操作：");
		sql = "delete from student where no = ?";
		pStatement = conn.prepareStatement(sql);
		pStatement.setString(1, "2014004");
		pStatement.executeUpdate();
		System.out.println("查询删除数据后的数据表：");
		sql = "select * from student";
		pStatement = conn.prepareStatement(sql);
		resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			String no = resultSet.getString(1);
			String name = resultSet.getString(2);
			System.out.print("NO:"+no+"\t");
			System.out.println("Name:"+name);
		}
		System.out.println("***********************");
		
		resultSet.close();
		pStatement.close();
		conn.close();
	}
}
