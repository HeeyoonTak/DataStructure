
package hw8_1;

public class CircularQueue {
	
		private int[] array;
		private int capacity;
		private int count;
		private int front;
		private int rear;
		public CircularQueue(int capacity) {
			super();
			this.capacity = capacity;
			array = new int[capacity];
		}
		public boolean isEmpty(){
			return count==0;
		}
		public boolean isFull(){
			return count==capacity;
		}
		public void enQueue(int data){
			if(isFull()){
				System.out.println("ť�� ���� á���ϴ�.");
			}
			else{
				rear=(rear+1)%capacity;
				array[rear]=data;
				count++;
			}
		}
		public int deQueue(){
			if(isEmpty()){
				System.out.println("ť�� ������ϴ�.");
			}
			else{
				front=(front+1)%capacity;
				count--;
			}
			return array[front];
		}
}
