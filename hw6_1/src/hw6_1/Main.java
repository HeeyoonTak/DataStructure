/*
 // ���ϸ�: hw6_1 .java
 // �ۼ���: Ź����
 // �ۼ���: 2016.10.06
 // ����:�������� �Է¹޾� ����Ʈ�� ������ �� ����� ���� ���α׷��� �ۼ��Ѵ�.
 */
package hw6_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("hw6_1:Ź����");
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int num;
		int data;
		
		do {
			System.out.println("1.ó���� ����  2.��ü��� 3.����");
			num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.println("���� �Է��ϼ���");
				data = scan.nextInt();
				list.frontInsert(data);
				break;
			case 2:
				list.print();
				System.out.println();
				break;
			case 3:
				System.out.println("�����մϴ�");
				return;

			}

		} while (num >= 1 || num <= 3);
		
	}

}
