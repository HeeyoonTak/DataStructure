package practice;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("201332039 Ź����");
		Scanner scan=new Scanner(System.in);
		double[] array=new double[50];
		int size=7;
		array[0]=0.0;
		array[1]=11.1;
		array[2]=22.3;
		array[3]=33.4;
		array[4]=44.0;
		array[5]=55.0;
		array[6]=66.7;
		
		System.out.println("ũ��:"+size);
		System.out.print("����:");
		for(int i=0;i<size;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("������ �ε��� �Է�:");
		int index=scan.nextInt();
		System.out.println("���� �� �� �Է�:");
		double num=scan.nextDouble();
		
		for(int j=0;j<array.length;j++){
			if(j==index){
				for(int i=size;i>=index;i--){
					array[i]=array[i-1];
					
				}
				
				break;
			}
		}
		array[index]=num;
		size++;
		System.out.println("ũ��:"+size);
		System.out.print("����:");
		for(int i=0;i<size;i++){
			System.out.print(array[i]+" ");
		}
	}

}
