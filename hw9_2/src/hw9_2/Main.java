/*
 // ���ϸ�: hw9_2.java
 // �ۼ���: Ź����
 // �ۼ���: 2016.11.22
 // ����:����Ž��Ʈ���� ���� �ڷᱸ���� �����Ѵ�.
 */
package hw9_2;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		System.out.println("hw9_2:Ź����");
		Scanner scan = new Scanner(System.in);
		IntegerBinarySearchTree tree =new IntegerBinarySearchTree();
		int num;
		do{
			System.out.println("1.Ʈ��������,2.Ʈ������ ����,3.Ʈ������ �˻�,4.������ȸ,5.����");
			num= scan.nextInt();
			switch(num){
			case 1:
				System.out.println("�Է� �� ����:");
				tree.add(scan.nextInt());
				break;
			case 2:
				System.out.println("���� �� ���� �Է�");
				tree.remove(scan.nextInt());
				break;
			case 3:
				System.out.println("�˻� �� ����");
				tree.search(scan.nextInt());
				break;
			case 4:
				tree.inorder();
				break;
			case 5:
				System.out.println("����");
				break;
			}
			}while(num >= 1 && num <= 4);
		
	}

}
