/*
 // 파일명: hw5_3 .java
 // 작성자: 탁희윤
 // 작성일: 2016.09.22
 // 설명:비어있는 문자열 리스트를 생성한 후,
다음 메뉴를 5을 입력할 때까지 반복하여 제공한다.
 */
package hw5_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_3:탁희윤");
		Scanner scan=new Scanner(System.in);
		StringList list=new StringList();
		int num;
		while(true){
			System.out.println("1:인덱스로삽입 2:삭제 3:인덱스로조회 4:전체출력 5:종료");
			num=scan.nextInt();

			if(num==1){
				System.out.print("인덱스 입력:");
				int index1=scan.nextInt();
				scan.nextLine();
				System.out.print("단어 입력:");
				String word2=scan.next();
				list.insert(index1, word2);
			}
			else if(num==2){
				scan.nextLine();
				System.out.print("단어 입력:");
				String word3=scan.next();
				list.delete(word3);
			}
			else if(num==3){
				System.out.print("인덱스 입력:");
				int index2=scan.nextInt();
				System.out.println(list.search(index2));
			}
			else if(num==4){
				System.out.println("길이: "+list.sizeSearch());
				System.out.println(list.toString());
			}
			else if(num==5)
				break;


		}
	}


}


