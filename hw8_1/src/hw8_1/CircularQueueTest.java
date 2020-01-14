/*
 // 파일명: hw8_1 .java
 // 작성자: 탁희윤
 // 작성일: 2016.11.15
 // 설명:원형큐를 나타내는 추상자료형인 CircularQueue 클래스를 정의하고 이용하는 프로그램을 작성하시오.
 */
package hw8_1;

public class CircularQueueTest {

	public static void main(String[] args) {
		System.out.println("hw8_1:탁희윤");
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


