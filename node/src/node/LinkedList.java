package node;



public class LinkedList {
	// ��� ���� ����
	Node head;	//���� �� ���
	public LinkedList(){
		head=null;
	}

	// ������ ����
	LinkedList(Node n) {
		this.head=n;
	}
	LinkedList(int i) {
		Node newNode= new Node(i);
		head=newNode;
	}
	// Linked List�� Node�� �߰��Ѵ�. ���� �ڿ� �ִ´�.
	public void add(Node n) {
		Node newNode = n;
		Node temp;//������ ���Ҹ� ã�����
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
	// �Ű������� ���� ������ Node�� ����� �߰��Ѵ�.
	public void add(int i) {
		Node temp = head; // ������ ��带 ã�� ��� ����, head���� ����
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
	// Linked List�� ������ ����Ѵ�.
	public void print(){
		Node temp=head;
		//System.out.print("����:");
		int i=1;
		while(temp!=null){
			System.out.print(i+"��° ��:");
			i++;
			System.out.print(temp.getV()+" ");
			System.out.println();
			temp=temp.link;
		}
	}
}
