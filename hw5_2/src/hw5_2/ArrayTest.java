//***************************
 // ���ϸ�: hw5_2 .java
 // �ۼ���: Ź����
 // �ۼ���: 2016.09.22
 // ����:���� �迭�� ������ ��������Ʈ���� ����ڰ� ���ϴ� (1)��ġ(�ε���)�� ���� �����ϰ�,
//      (2)����ڰ� ���ϴ� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//***************************
package hw5_2;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		System.out.println("hw5_2:Ź����");
		Scanner scan = new Scanner(System.in);
		int array[] = new int[100];
		int size=10;
		array[0]=0;
		array[1]=11;
		array[2]=22;
		array[3]=33;
		array[4]=44;
		array[5]=55;
		array[6]=66;
		array[7]=77;
		array[8]=88;
		array[9]=99;

		System.out.println("�ʱ� ����Ʈ");
		System.out.println("����:"+size);
		System.out.print("����:");
		for(int i=0; i<size; i++){
			System.out.print(array[i]+", ");
		}
		System.out.println("");
		System.out.println("");

		System.out.print("���� �� �ε���:");
		int index = scan.nextInt();
		while(index>9 || index<0){
			System.out.print(">>> ������ �ε��� ���Է�(0~9): ");
			index=scan.nextInt();
		}
		if(index>9){
			while(index<10 || index>=0)
				System.out.println("������ �ε��� ���Է�(0~9): ");
		}
		for(int i=index; i<size; i++){
			array[i]=array[i+1];
		}
		size--;
		System.out.println("���� �� ����Ʈ");
		System.out.println("����:"+size);
		System.out.print("����:");
		for(int i=0; i<size; i++){
			System.out.print(array[i]+", ");
		}
		System.out.println("");
		System.out.println("");

		System.out.print("������ ��:");
		int num = scan.nextInt();
		for(int i=0; i<size; i++){
			while(array[i] != num){
				System.out.print("������ �� ���Է�: ");
				num=scan.nextInt();
			}
			break;
		}
		for(int i=0; i<size; i++){
			if(array[i]==num){
				array[i]=array[i+1];
				array[i+1]=array[i+2];
				array[i+2]=array[i+3];
				array[i+3]=array[i+4];
				array[i+4]=array[i+5];
				array[i+5]=array[i+6];
				array[i+6]=array[i+7];
				array[i+7]=array[i+8];
				array[i+8]=array[i+9];
				break;
			}
		}
		size--;
		System.out.println("���� �� ����Ʈ");
		System.out.println("����:"+size);
		System.out.print("����:");
		for(int i=0; i<size; i++){
			System.out.print(array[i]+", ");
		}
	}
}
