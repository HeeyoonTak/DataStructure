package hw6_2;



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
	}//처음에 삽입: 정수를 매개변수로 받아 처음 위치에 삽입한다.
	public void print(){
		Node temp=head;
		System.out.print("내용:");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.link;
		}//내용조회: 리스트 내용을 문자열로 만들어 리턴(toString 오버라이드)

	}
	public int size(){
		return count;
	}
	public void indexInsert(int index, int data){
		Node newNode=new Node(data);
		if(head == null) {
			System.out.println("리스트가 비어있었으므로 첫번재인덱스삽입합니다.");
			frontInsert(data);
		}
		else {
			if(index==0){
				frontInsert(data);
			}
			else if(index<=count-1){
				middleInsert(index, data);
			}
			else if(index==count){
				lastInsert(data);
			}
			else{
				System.out.println("벗어난 값을 입력하셨습니다.");
			}
		}
		
	}//사용자로부터 인덱스와 정수를 입력받아 삽입
	public void indexDelete(int index){
		Node temp=head;
		Node pre=null;
		if(index<0 || index>=count){
			System.out.println("인덱스의 크기가 벗어났습니다.");
		}
		else{
			if(index==0){
				head=head.link;
				count--;
			}
			else if(index<=count-1){
				for(int i=0;i<index;i++){
					pre=temp;
					temp=temp.link;
				}
				pre.link=temp.link;
				count--;
			}
			else if(index==count){
				temp = head;
				while(temp.link != null) {
					pre = temp;
					temp = temp.link;
				}
				pre.link = null;
				count--;
			}
			else{
				System.out.println("삭제값이 잘 못 되었습니다.");
			}
		}
	}//사용자로부터 인덱스를 받아서 삭제
	public void delete(int data){
		Node temp=head;
		Node pre=null;
		if(head==null)
			System.out.println("지울 노드가 없습니다.");
		
		else{
			
			//첫리스트 삭제할때
			if(temp.data == data) {
				head = temp.link;
				count--;
			}
			//중간값
			else if(search(data).link !=null) {
				pre=head;
				temp=head.link;
				while(temp.data != search(data).data){
					pre=temp;
					temp=temp.link;
				}
				pre.link=search(data).link;
				count--;
			}
			
			else if(search(data).link == null){
				temp = head;
				while(temp.link != null) {
					pre = temp;
					temp = temp.link;
				}
				pre.link = null;
				count--;
			}
			//예외
			else {
				System.out.println("값이 없습니다.");
			}
				
			
//			System.out.println("preNode : " +pre.data);
//			System.out.println("deleteNode :  "+ search(data).data);
			
		}
	}//정수와 삭제할 노드의 전 노드의 참조변수를 매개변수로 받아서  해당 위치의 노드 삭제
	public void lastInsert(int data){
		Node newNode = new Node(data);
		Node temp;
		if(head==null){
			head=newNode;
		}
		else{
			temp=head;
			while(temp.link!=null){
				temp=temp.link;
			}
			temp.link=newNode;
		}
		count++;
	}//정수를 매개변수로 받아 마지막 위치에 삽입한다.
	public void middleInsert(int index, int data){
		Node temp = head;
		Node newNode = new Node(data);
		int indexCount=0;
		while(indexCount<index-1) {
			temp = temp.link;
			indexCount++;
		}
		newNode.link = temp.link;
		temp .link = newNode;
		count++;
	}// 정수와 삭제할 노드의 전 노드의 참조변수를 매개변수로 받아서  해당 위치의 노드 삭제
	public Node search(int data) {
		Node temp=head;

		while(temp!=null){
			if(temp.data==data){
				return temp;
			}
			else
				temp=temp.link;
		}
		System.out.println("searchNode : " + temp.data);
		return temp;
	}
	public int get(int index){
		return getNode(index).data;
	}  // index 위치의 데이터를 반환



	public Node getNode(int index){
		Node temp=head;
		for(int i =0; i < index; i++){
			temp=temp.link;
		}

		return temp;
	}  // index 위치의 노드를 반환

}
