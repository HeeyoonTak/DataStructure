package hw6_1;

public class LinkedList {
	Node head;
	int count=0;
	public LinkedList(){
		head=null;
	}
	public void frontInsert(int data){
		Node newNode = new Node(data);
		newNode.link=head;
		newNode.data=data;
		head=newNode;
		count++;
	}
	public void print(){
		Node temp=head;
		System.out.print("내용:");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.link;
		}
		System.out.println("");
		System.out.println("길이: "+count);
	}
	public int size(){
		return count;
	}
}
