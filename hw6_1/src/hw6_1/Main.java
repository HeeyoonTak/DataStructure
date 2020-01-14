/*
 // 파일명: hw6_1 .java
 // 작성자: 탁희윤
 // 작성일: 2016.10.06
 // 설명:정수값을 입력받아 리스트에 저장한 후 출력해 보는 프로그램을 작성한다.
 */
package hw6_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("hw6_1:탁희윤");
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int num;
		int data;
		
		do {
			System.out.println("1.처음에 삽입  2.전체출력 3.종료");
			num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.println("값을 입력하세요");
				data = scan.nextInt();
				list.frontInsert(data);
				break;
			case 2:
				list.print();
				System.out.println();
				break;
			case 3:
				System.out.println("종료합니다");
				return;

			}

		} while (num >= 1 || num <= 3);
		
	}

}
