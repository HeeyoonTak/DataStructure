/*
 // ���ϸ�: hw8_1 .java
 // �ۼ���: Ź����
 // �ۼ���: 2016.11.15
 // ����:����ť�� ��Ÿ���� �߻��ڷ����� CircularQueue Ŭ������ �����ϰ� �̿��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
package hw8_1;

public class CircularQueueTest {

	public static void main(String[] args) {
		System.out.println("hw8_1:Ź����");
		CircularQueue cq = new CircularQueue(5);
		cq.enQueue(1);
		cq.enQueue(3);
		cq.enQueue(5);
		cq.enQueue(7);
		cq.enQueue(9);
		cq.deQueue();
		cq.deQueue();
		cq.enQueue(2);
		cq.enQueue(5);
		cq.enQueue(6);
		while(!cq.isEmpty()){
			System.out.print(cq.deQueue()+" ");
		}
		System.out.println();
		cq.deQueue();
		}
	}


