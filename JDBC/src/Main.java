import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	private static final String CONNECT = "jdbc:oracle:thin:@localhost:1522:orcl";
	private static final String USER = "HR";
	private static final String PASSWD = "thy1003";

	public static void main(String[] args) throws SQLException {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(CONNECT, USER, PASSWD);

			System.out.println("라이브러리 로드 성공");
			System.out.println("접속 성공");
			
			String query = "SELECT * FROM EMPLOYEES";
			String query2 = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID=? and SALary>=?";
			
			//Statement stat = conn.createStatement();
			PreparedStatement pstmt=conn.prepareStatement(query2);
			pstmt.setInt(1,1000);
			pstmt.setInt(2, 1000);
			ResultSet rs = pstmt.executeQuery();//결과저장
			while(rs.next()){
				int EMPNO = rs.getInt("EMPLOYEE_ID");
				String ENAME = rs.getString("LAST_NAME");
				
				System.out.println(EMPNO+"/"+ENAME);
			}
			rs.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("라이브러리 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		} finally {
			conn.close();
		}
	}

}
