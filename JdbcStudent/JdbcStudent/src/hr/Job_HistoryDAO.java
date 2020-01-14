package hr;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;
import util.DB;

public class Job_HistoryDAO extends DAO{
	private static Job_History makeHistory(ResultSet rs) throws Exception{
		Job_History obj = new Job_History();
		obj.setEmployee_id(rs.getInt("employee_id)"));
		obj.setStart_date(rs.getDate("start_date"));
		obj.setEnd_date(rs.getDate("end_date"));
		obj.setJob_id(rs.getString("job_id"));
		obj.setDepartment_id(rs.getInt("department_id"));
		return obj;
	}
	public static ArrayList<Job_History> selectAll() throws Exception{
		String sql="SELECT employee_id, start_date, end_date, job_id, department_id FROM Job_History";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			con=DB.getConnection();
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			ArrayList<Job_History> list=new ArrayList<Job_History>();
			while(rs.next())list.add(makeHistory(rs));
			return list;
		}
		finally{
			close(con,stmt,rs);
		}
	}
	public static void insert(int employee_id,String start_date,String end_date,String job_id,int department_id)throws Exception{
		String sql="INSERT INTO Job_History(employee_id, start_date, end_date, job_id, department_id) VALUES(?,?,?,?,?)";
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			con=DB.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, employee_id);
			stmt.setString(2, start_date);
			stmt.setString(3, end_date);
			stmt.setString(4, job_id);
			stmt.setInt(5, department_id);
			System.out.println(stmt.toString());
			stmt.executeUpdate();
		}catch(SQLException e){
			int e_code=e.getErrorCode();
        	// 각 오류 번호에 따라 서로 다른 작업을 할 수 있다.
        	switch (e_code) {
        	case 1:
        		System.out.println("중복 입력은 불가합니다.");
        		break;
        	case 2291:
        		System.out.println("존재하지 않는 Job_id, Employee_id, Department_id입니다.");
        		break;        		
        	case 1861:
        		System.out.println("데이터 입력 양식이 맞지 않습니다.");
        		break; 
        	}
        	printError(e);
        }
	    finally {
	    	close(con, stmt, rs);
		}
	}
	public static ArrayList<Job_History> selectJobHistoryForHighSalarySum() throws Exception {
    	// Stored Procedure를 호출하여 여러 개의 결과를 반환하는 경우이다. 
    	// Stored Procedure를 호출하기 위해서는 CallableStatement를 사용한다.
    	
    	// Stored Procedure를 호출하기 위한 문자열 작성
    	// 설정해야 하는 매개변수 부분은 ?로 표기
    	// 여러 개의 row를 결과로 받는 Stored Procedure의 경우,
    	// SYS_REFCURSOR 타입의 매개변수가 OUT 모드로 정의되어야 한다.
        String sql = "{call hr.get_jh_for_high_salary_sum(?)}";
        Connection con=null;
        CallableStatement stmt=null;
        ResultSet rs=null;
        // 결과를 저장하기 위한 리스트 정의
        ArrayList<Job_History> list = new ArrayList<Job_History>();
        try {
        	con = DB.getConnection();
        	stmt= con.prepareCall(sql);
        	// Out모드 매개변수를 설정한다.
        	stmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Stored Procedure를 실행하기 위해서는 아래 명령을 실행한다.
        	stmt.executeQuery();    	
            // 결과 집합에 하나 이상의 데이터가 포함될 수 있으므로, list와 반복문으로 처리한다.
        	// 첫번째 매개변수값을 Object로 가져와서 ResultSet으로 형 변환한다.
        	rs = (ResultSet)stmt.getObject(1);
        	while (rs.next()) {
        		// 가져온 결과를 결과 list에 추가한다.
            	list.add(makeHistory(rs));
            	// 첫번째 매개변수값을 Object로 가져와서 ResultSet으로 형 변환한다.
            	rs = (ResultSet)stmt.getObject(1);
            }
        }
        catch (SQLException e) {     	
  	       printError(e);
        }
	    finally {
	    	close(con, stmt, rs);
	    }
       	return list;
    }
}
