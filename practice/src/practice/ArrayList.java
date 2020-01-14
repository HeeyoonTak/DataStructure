package practice;

import java.util.Arrays;


public class ArrayList {
	private double[] array;
	private int size;
	public ArrayList() {
		super();
		array=new double[50];
		size=0;
	}
	public void insert(int index, double num){
		if(index>array.length-1) {
			System.out.println("���� ũ�� ���� �Ѿ���ϴ�.");
		}
		for(int i=array.length-2; i>index;i++){
			array[i+1]=array[i];
			array[index]=num;
		}
		size++;
		if(size<index){
			size=index+1;
		}
	}
	public void print(){
		System.out.println("����:"+size);
		System.out.print("����:");
		for(int i=0;i<size;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
