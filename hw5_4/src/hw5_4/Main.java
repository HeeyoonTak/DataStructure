/*
 // ���ϸ�: hw5_4 .java
 // �ۼ���: Ź����
 // �ۼ���: 2016.09.22
 // ����:������ 1���� �迭�� �̿��� ���׽� ǥ���� �̿��Ͽ�
 �Ʒ� ���׽�(Ai, Bi)�� ���Ͽ� ���ο� ���׽�(Ci)�� ���ϰ� �� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
package hw5_4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_4:Ź����");

		double a1[] = {9, 4, 5, 0};
		double b1[] = {8, 1, -3, 2.5, 1.8};
		double c1[] = null;
		int index;
		if(a1.length<b1.length){
			c1 = new double[b1.length];
			index=b1.length-a1.length;
			for(int i=0;i<index;i++){
				c1[i]=b1[i];
			}
			for(int i=index;i<b1.length;i++){
				c1[i]=a1[i-index]+b1[i];
			}
		}
		System.out.print("C1�� ���:");
		for(int i=0; i<b1.length; i++){
			System.out.print(" "+c1[i]);
		}
		System.out.println("");
		
		double a2[] = {3, 4, 5, 6, 7};
		double b2[] = {-3, -4, 4, 6, 0};
		double c2[] = null;
		if(a2.length==b2.length){
			c2 = new double[a2.length];
			for(int i=0; i<a1.length+1;i++){
				c2[i]=a2[i]+b2[i];
			}
		}
		System.out.print("C2�� ���:");
		for(int i=0; i<b1.length; i++){
			System.out.print(" "+c2[i]);
		}
		System.out.println("");
		
		double a3[] = {7, -6, 5, 3, 3, 1.5, 2.5};
		double b3[] = {6, 3, 2, 1, 0, 7, -2.5};
		double c3[] = null;
		if(a3.length==b3.length){
			c3 = new double[a3.length];
			for(int i=0; i<a3.length;i++){
				c3[i]=a3[i]+b3[i];
			}
		}
		System.out.print("C3�� ���:");
		for(int i=0; i<a3.length; i++){
			System.out.print(" "+c3[i]);
		}
		
	}
}