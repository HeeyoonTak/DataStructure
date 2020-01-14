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
        	// �� ���� ��ȣ�� ���� ���� �ٸ� �۾��� �� �� �ִ�.
        	switch (e_code) {
        	case 1:
        		System.out.println("�ߺ� �Է��� �Ұ��մϴ�.");
        		break;
        	case 2291:
        		System.out.println("�������� �ʴ� Job_id, Employee_id, Department_id�Դϴ�.");
        		break;        		
        	case 1861:
        		System.out.println("������ �Է� ����� ���� �ʽ��ϴ�.");
        		break; 
        	}
        	printError(e);
        }
	    finally {
	    	close(con, stmt, rs);
		}
	}
	public static ArrayList<Job_History> selectJobHistoryForHighSalarySum() throws Exception {
    	// Stored Procedure�� ȣ���Ͽ� ���� ���� ����� ��ȯ�ϴ� ����̴�. 
    	// Stored Procedure�� ȣ���ϱ� ���ؼ��� CallableStatement�� ����Ѵ�.
    	
    	// Stored Procedure�� ȣ���ϱ� ���� ���ڿ� �ۼ�
    	// �����ؾ� �ϴ� �Ű����� �κ��� ?�� ǥ��
    	// ���� ���� row�� ����� �޴� Stored Procedure�� ���,
    	// SYS_REFCURSOR Ÿ���� �Ű������� OUT ���� ���ǵǾ�� �Ѵ�.
        String sql = "{call hr.get_jh_for_high_salary_sum(?)}";
        Connection con=null;
        CallableStatement stmt=null;
        ResultSet rs=null;
        // ����� �����ϱ� ���� ����Ʈ ����
        ArrayList<Job_History> list = new ArrayList<Job_History>();
        try {
        	con = DB.getConnection();
        	stmt= con.prepareCall(sql);
        	// Out��� �Ű������� �����Ѵ�.
        	stmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Stored Procedure�� �����ϱ� ���ؼ��� �Ʒ� ����� �����Ѵ�.
        	stmt.executeQuery();    	
            // ��� ���տ� �ϳ� �̻��� �����Ͱ� ���Ե� �� �����Ƿ�, list�� �ݺ������� ó���Ѵ�.
        	// ù��° �Ű��������� Object�� �����ͼ� ResultSet���� �� ��ȯ�Ѵ�.
        	rs = (ResultSet)stmt.getObject(1);
        	while (rs.next()) {
        		// ������ ����� ��� list�� �߰��Ѵ�.
            	list.add(makeHistory(rs));
            	// ù��° �Ű��������� Object�� �����ͼ� ResultSet���� �� ��ȯ�Ѵ�.
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
