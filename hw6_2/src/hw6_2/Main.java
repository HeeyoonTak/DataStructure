/*
 // ���ϸ�: hw6_2 .java
 // �ۼ���: Ź����
 // �ۼ���: 2016.10.06
 // ����:�������� �Է¹޾� ����Ʈ�� ������ �� ����� ���� ���α׷��� �ۼ��Ѵ�.
 */
package hw6_2;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		System.out.println("hw6_2:Ź����");
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int num;
		int data;
		int index;
		do {
			System.out.println("1.�ε����� ���� 2.�ε����� ����  3.�ش簪���� 4.��ü��� 5.����");
			num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.print("�ε����� �Է��ϼ���:");
				index=scan.nextInt();
				System.out.print("������ �Է��ϼ���.:");
				data=scan.nextInt();
				list.indexInsert(index, data);
				break;
			case 2:
				System.out.print("�ε����� �Է��ϼ���:");
				index=scan.nextInt();
				list.indexDelete(index);
				break;
			case 3:
				System.out.print("������ ���� �Է��ϼ���");
				data = scan.nextInt();
				list.delete(data);
				break;
			case 4:
				list.print();
				System.out.println("");
				System.out.println("ũ��:"+list.size());
				break;
			case 5:
				System.out.println("�����մϴ�");
				return;

			}

		} while (num >= 1 || num <= 5);
	}

}
