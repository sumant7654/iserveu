package in.iserveu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCurd {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "root");

			Statement st = con.createStatement();
			int x = st.executeUpdate(
					"insert into Employee(id,name,email,phone,salary) values(1,'Sumant','sumant@gmail.com','9900130375L',10000.00)");
			if (x > 0) {
				System.out.println("Row Inserted Successfully");
			} else {
				System.out.println("Not Inserted!! Please check Your Data");
			}
			int y = st.executeUpdate("update Employee set phone=9448776496L where id=1");

			if (y > 0) {
				System.out.println(y + "\t Row Updated");
			}

			ResultSet rs = st.executeQuery("select id,name,email,phone,salary from Employee where id=1");
			while (rs.next()) {
				System.out.println("Employee Id =\t" + rs.getInt("id") + "\nEmployee Name =\t" + rs.getString("name")
						+ "\nEmployee Email =\t" + rs.getString("email") + "\nEmployee Phone =\t" + rs.getLong("phone")
						+ "\nEmployee Salary =\t" + rs.getDouble("salary"));
			}

			int z = st.executeUpdate("delete from Employee where email='sumant@gmail.com'");
			if (z > 0) {
				System.out.println(z + " No of Row Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.close();

			}
		}

	}

}
