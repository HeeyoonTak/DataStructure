/*
 // 파일명: hw9_2.java
 // 작성자: 탁희윤
 // 작성일: 2016.11.22
 // 설명:이진탐색트리는 연결 자료구조로 구현한다.
 */
package hw9_2;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		System.out.println("hw9_2:탁희윤");
		Scanner scan = new Scanner(System.in);
		IntegerBinarySearchTree tree =new IntegerBinarySearchTree();
		int num;
		do{
			System.out.println("1.트리에삽입,2.트리에서 삭제,3.트리에서 검색,4.중위순회,5.종료");
			num= scan.nextInt();
			switch(num){
			case 1:
				System.out.println("입력 할 정수:");
				tree.add(scan.nextInt());
				break;
			case 2:
				System.out.println("삭제 할 정수 입력");
				tree.remove(scan.nextInt());
				break;
			case 3:
				System.out.println("검색 할 정수");
				tree.search(scan.nextInt());
				break;
			case 4:
				tree.inorder();
				break;
			case 5:
				System.out.println("종료");
				break;
			}
			}while(num >= 1 && num <= 4);
		
	}

}
