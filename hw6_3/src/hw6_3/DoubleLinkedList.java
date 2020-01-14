package hw6_3;


public class DoubleLinkedList {
	Node head;	
	int count=0;
	public DoubleLinkedList(){
		head=null;
	}
	public void frontInsert(int data){
		Node newNode = new Node(data);
		Node temp=head;
		if(head==null){
			head=newNode;
		}
		else{
			newNode.rlink=temp;
			temp.llink=newNode;
			head=newNode;
		}
		count++;
	}//ó���� ����: ������ �Ű������� �޾� ó�� ��ġ�� �����Ѵ�.
	public void print(){
		Node temp=head;
		Node pre=null;
		System.out.print("����:");
		while(temp!=null){
			System.out.print(temp.data+" ");
			pre=temp;
			temp=temp.rlink;
		}//������ȸ: ����Ʈ ������ ���ڿ��� ����� ����(toString �������̵�)
		System.out.println("");
		while(pre!=null){
			System.out.print(pre.data+" ");
			pre=pre.llink;
		}
	}
	public int size(){
		return count;
	}
	public void indexInsert(int index, int data){
		Node newNode=new Node(data);
		if(head == null) {
			System.out.println("����Ʈ�� ����־����Ƿ� ù�����ε��������մϴ�.");
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
				System.out.println("��� ���� �Է��ϼ̽��ϴ�.");
			}
		}
		
	}//����ڷκ��� �ε����� ������ �Է¹޾� ����
	public void indexDelete(int index){
		Node temp=head;
		Node pre=null;
		if(index<0 || index>=count){
			System.out.println("�ε����� ũ�Ⱑ ������ϴ�.");
		}
		else{
			if(index==0){
				head=head.rlink;
				head.llink=null;
				count--;
			}
			else if(index<count-1){
				for(int i=0;i<index;i++){
					pre=temp;
					temp=temp.rlink;
					temp.llink=pre;
				}
				temp.rlink.llink=pre;
				pre.rlink=temp.rlink;
				count--;
			}
			else if(index==count-1){
				temp = head;
				while(temp.rlink != null) {
					pre = temp;
					temp = temp.rlink;
					temp.llink=pre;
				}
				pre.rlink = null;
				count--;
			}
			else{
				System.out.println("�������� �� �� �Ǿ����ϴ�.");
			}
		}
	}//����ڷκ��� �ε����� �޾Ƽ� ����
	public void delete(int data){
		Node temp=head;
		Node pre=null;
		if(head==null)
			System.out.println("���� ��尡 �����ϴ�.");
		
		else{
			
			//ù����Ʈ �����Ҷ�
			if(temp.data == data) {
				head = temp.rlink;
				temp.rlink.llink=null;
				count--;
			}
			//�߰���
			else if(search(data).rlink !=null) {
				pre=head;
				temp=head.rlink;
				temp.llink=pre;
				while(temp.data != search(data).data){
					pre=temp;
					temp=temp.rlink;
				}
				search(data).rlink.llink=pre;
				pre.rlink=search(data).rlink;
				
				count--;
			}
			//������ ��
			else if(search(data).rlink == null){
				temp = head;
				while(temp.rlink != null) {
					pre = temp;
					temp = temp.rlink;
					temp.llink=pre;
				}
				pre.rlink = null;
				count--;
			}
			//����
			else {
				System.out.println("���� �����ϴ�.");
			}
				
			
		}
	}//������ ������ ����� �� ����� ���������� �Ű������� �޾Ƽ�  �ش� ��ġ�� ��� ����
	public void lastInsert(int data){
		Node newNode = new Node(data);
		Node temp;
		if(head==null){
			head=newNode;
		}
		else{
			temp=head;
			while(temp.rlink!=null){
				temp=temp.rlink;
			}
			temp.rlink=newNode;
			newNode.llink=temp;
		}
		count++;
	}//������ �Ű������� �޾� ������ ��ġ�� �����Ѵ�.
	public void middleInsert(int index, int data){
		Node temp = head;
		Node pre=null;
		Node newNode = new Node(data);
		int indexCount=0;
		while(indexCount<index-1) {
			pre=temp;
			temp = temp.rlink;
			indexCount++;
		}
		pre.rlink.llink=newNode;
		newNode.rlink=pre.rlink;
		pre.rlink=newNode;
		newNode.llink=pre;
		count++;
	}// ������ ������ ����� �� ����� ���������� �Ű������� �޾Ƽ�  �ش� ��ġ�� ��� ����
	public Node search(int data) {
		Node temp=head;

		while(temp!=null){
			if(temp.data==data){
				return temp;
			}
			else
				temp=temp.rlink;
		}
		System.out.println("searchNode : " + temp.data);
		return temp;
	}
	public int get(int index){
		return getNode(index).data;
	}  // index ��ġ�� �����͸� ��ȯ



	public Node getNode(int index){
		Node temp=head;
		for(int i =0; i < index; i++){
			temp=temp.rlink;
		}

		return temp;
	}  // index ��ġ�� ��带 ��ȯ

}
