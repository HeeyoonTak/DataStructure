package hr;
// 필요한 패키지를 import 한다.
import java.util.ArrayList;
import java.util.Scanner;

// 화면 입출력과 테스트를 위한 클래스를 정의한다.

public class test {
	static Scanner input;
	
	public static void selectAll()  throws Exception{
//    	ArrayList<Job> list = JobDAO.selectAll();
	   	ArrayList<Job> list = JobDAO.selectJobs();
        for (Job j: list) {
 	       System.out.printf("%-10s", j.getJob_id());
 	       System.out.printf("%-30s", j.getJob_title());
 	       System.out.printf("%7d", j.getMax_salary());
 	       System.out.printf("%7d\n", j.getMin_salary());
        }		
	}
	
	public static void selectByJob_id() throws Exception {
	       System.out.print("Job Id:");
	       String job_id=input.next();
	       input.nextLine();//개행문자 없애기
	       Job j = JobDAO.selectByJob_Id(job_id);
	       if (j==null) {
		       System.out.printf("%s에 해당하는 Job은 없습니다.\n", job_id);
		       return;
	       }
 	       System.out.printf("%-10s", j.getJob_id());
 	       System.out.printf("%-30s", j.getJob_title());
 	       System.out.printf("%7d", j.getMax_salary());
 	       System.out.printf("%7d\n", j.getMin_salary());
	       System.out.println();  		
	}
	
	public static void insert()  throws Exception {
	       System.out.print("Job Id:");
	       String job_id=input.next();
	       input.nextLine();//개행문자 없애기
	       System.out.print("Job Title:");
	       String job_title=input.next();
	       input.nextLine();//개행문자 없애기		
	       System.out.print("Max Salary:");
	       int max_salary=input.nextInt();
	       System.out.print("Min Salary:");
	       int min_salary=input.nextInt();
	       JobDAO.insert(job_id, job_title, max_salary, min_salary);	       
	}

	public static void update()  throws Exception {
	       System.out.print("수정할 Job Id:");
	       String job_id=input.next();
	       input.nextLine();//개행문자 없애기
	       System.out.print("Job Title:");
	       String job_title=input.next();
	       input.nextLine();//개행문자 없애기		
	       System.out.print("Max Salary:");
	       int max_salary=input.nextInt();
	       System.out.print("Min Salary:");
	       int min_salary=input.nextInt();
	       JobDAO.update(job_id, job_title, max_salary, min_salary);	       
	}	
	
	public static void delete()  throws Exception {
	       System.out.print("삭제할 Job Id:");
	       String job_id=input.next();
	       input.nextLine();//개행문자 없애기
	       JobDAO.delete(job_id);	       
	}	
	
	
	public static void main(String[] args) throws Exception {
	    input=new Scanner(System.in);
    	while (true) {
 	       System.out.println("1: Job 전체 출력");
 	       System.out.println("2: 특정 Job ID 출력"); 	       
 	       System.out.println("3: Job 신규 입력");
 	       System.out.println("4: Job 수정"); 
 	       System.out.println("5: 특정 Job ID 삭제");
 	       System.out.println("9: 종료"); 
 	       System.out.println("선택:");
	       int menu=input.nextInt();
	       switch (menu) {
	       case 1: 
	    	   selectAll();
	    	   break;
	       case 2:
	    	   selectByJob_id();
	    	   break;
	       case 3:
	    	   insert();
	    	   break;
	       case 4:
	    	   update();
	    	   break;
	       case 5:
	    	   delete();
	    	   break;
	       }
	       if (menu >= 9) {
	    	   System.out.println("종료되었습니다.");
	    	   break;
	       }
    	}
    	input.close();
    }
}
