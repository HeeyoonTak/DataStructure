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
	}//ó���� ����: ������ �Ű������� �޾� ó�� ��ġ�� �����Ѵ�.
	public void print(){
		Node temp=head;
		System.out.print("����:");
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.link;
		}//������ȸ: ����Ʈ ������ ���ڿ��� ����� ����(toString �������̵�)

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
				head = temp.link;
				count--;
			}
			//�߰���
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
			//����
			else {
				System.out.println("���� �����ϴ�.");
			}
				
			
//			System.out.println("preNode : " +pre.data);
//			System.out.println("deleteNode :  "+ search(data).data);
			
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
			while(temp.link!=null){
				temp=temp.link;
			}
			temp.link=newNode;
		}
		count++;
	}//������ �Ű������� �޾� ������ ��ġ�� �����Ѵ�.
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
	}// ������ ������ ����� �� ����� ���������� �Ű������� �޾Ƽ�  �ش� ��ġ�� ��� ����
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
	}  // index ��ġ�� �����͸� ��ȯ



	public Node getNode(int index){
		Node temp=head;
		for(int i =0; i < index; i++){
			temp=temp.link;
		}

		return temp;
	}  // index ��ġ�� ��带 ��ȯ

}
