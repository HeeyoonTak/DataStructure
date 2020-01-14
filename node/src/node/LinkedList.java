package node;



public class LinkedList {
	// 멤버 변수 정의
	Node head;	//고정 할 노드
	public LinkedList(){
		head=null;
	}

	// 생성자 정의
	LinkedList(Node n) {
		this.head=n;
	}
	LinkedList(int i) {
		Node newNode= new Node(i);
		head=newNode;
	}
	// Linked List에 Node를 추가한다. 제일 뒤에 넣는다.
	public void add(Node n) {
		Node newNode = n;
		Node temp;//마지막 원소를 찾을노드
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
	}
	// 매개변수로 받은 정수를 Node로 만들어 추가한다.
	public void add(int i) {
		Node temp = head; // 마지막 노드를 찾을 노드 선언, head부터 시작
		Node newNode= new Node(i);
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
	}
	// Linked List의 내용을 출력한다.
	public void print(){
		Node temp=head;
		//System.out.print("내용:");
		int i=1;
		while(temp!=null){
			System.out.print(i+"번째 값:");
			i++;
			System.out.print(temp.getV()+" ");
			System.out.println();
			temp=temp.link;
		}
	}
}
