/*
 // ���ϸ�: hw5_3 .java
 // �ۼ���: Ź����
 // �ۼ���: 2016.09.22
 // ����:����ִ� ���ڿ� ����Ʈ�� ������ ��,
���� �޴��� 5�� �Է��� ������ �ݺ��Ͽ� �����Ѵ�.
 */
package hw5_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_3:Ź����");
		Scanner scan=new Scanner(System.in);
		StringList list=new StringList();
		int num;
		while(true){
			System.out.println("1:�ε����λ��� 2:���� 3:�ε�������ȸ 4:��ü��� 5:����");
			num=scan.nextInt();

			if(num==1){
				System.out.print("�ε��� �Է�:");
				int index1=scan.nextInt();
				scan.nextLine();
				System.out.print("�ܾ� �Է�:");
				String word2=scan.next();
				list.insert(index1, word2);
			}
			else if(num==2){
				scan.nextLine();
				System.out.print("�ܾ� �Է�:");
				String word3=scan.next();
				list.delete(word3);
			}
			else if(num==3){
				System.out.print("�ε��� �Է�:");
				int index2=scan.nextInt();
				System.out.println(list.search(index2));
			}
			else if(num==4){
				System.out.println("����: "+list.sizeSearch());
				System.out.println(list.toString());
			}
			else if(num==5)
				break;


		}
	}


}


