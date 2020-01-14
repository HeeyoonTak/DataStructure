//***************************
 // 파일명: hw5_2 .java
 // 작성자: 탁희윤
 // 작성일: 2016.09.22
 // 설명:정수 배열로 구현한 선형리스트에서 사용자가 원하는 (1)위치(인덱스)의 값을 삭제하고,
//      (2)사용자가 원하는 값을 삭제하는 프로그램을 작성하시오.
//***************************
package hw5_2;

import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args) {
		System.out.println("hw5_2:탁희윤");
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

		System.out.println("초기 리스트");
		System.out.println("길이:"+size);
		System.out.print("내용:");
		for(int i=0; i<size; i++){
			System.out.print(array[i]+", ");
		}
		System.out.println("");
		System.out.println("");

		System.out.print("삭제 할 인덱스:");
		int index = scan.nextInt();
		while(index>9 || index<0){
			System.out.print(">>> 삭제할 인덱스 재입력(0~9): ");
			index=scan.nextInt();
		}
		if(index>9){
			while(index<10 || index>=0)
				System.out.println("삭제할 인덱스 재입력(0~9): ");
		}
		for(int i=index; i<size; i++){
			array[i]=array[i+1];
		}
		size--;
		System.out.println("삭제 후 리스트");
		System.out.println("길이:"+size);
		System.out.print("내용:");
		for(int i=0; i<size; i++){
			System.out.print(array[i]+", ");
		}
		System.out.println("");
		System.out.println("");

		System.out.print("삭제할 값:");
		int num = scan.nextInt();
		for(int i=0; i<size; i++){
			while(array[i] != num){
				System.out.print("삭제할 값 재입력: ");
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
		System.out.println("삭제 후 리스트");
		System.out.println("길이:"+size);
		System.out.print("내용:");
		for(int i=0; i<size; i++){
			System.out.print(array[i]+", ");
		}
	}
}
