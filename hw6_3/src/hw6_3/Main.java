/*
 // 파일명: hw6_3 .java
 // 작성자: 탁희윤
 // 작성일: 2016.10.13
 // 설명:hw6_2과 동일한 기능을 하는 프로그램을 이중연결리스트를 이용하여 작성하시오.
 */
package hw6_3;

import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		System.out.println("hw6_3:탁희윤");
		Scanner scan = new Scanner(System.in);
		DoubleLinkedList list = new DoubleLinkedList();
		int num;
		int data;
		int index;
		do {
			System.out.println("1.인덱스로 삽입 2.인덱스로 삭제  3.해당값삭제 4.전체출력 5.종료");
			num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.print("인덱스를 입력하세요:");
				index=scan.nextInt();
				System.out.print("정수를 입력하세요.:");
				data=scan.nextInt();
				list.indexInsert(index, data);
				break;
			case 2:
				System.out.print("인덱스를 입력하세요:");
				index=scan.nextInt();
				list.indexDelete(index);
				break;
			case 3:
				System.out.print("삭제할 값을 입력하세요");
				data = scan.nextInt();
				list.delete(data);
				break;
			case 4:
				list.print();
				System.out.println("");
				System.out.println("크기:"+list.size());
				break;
			case 5:
				System.out.println("종료합니다");
				return;

			}

		} while (num >= 1 || num <= 5);
	}

}
