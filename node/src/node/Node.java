package node;


public class Node {
	// 멤버 변수 정의
	int v;
	Node link;
	// 생성자
	public Node(int i) {
		this.v=i;
	}
	// getter 정의
	public int getV() {
		return v;
	}
	// setter 정의
	public void setV(int v) {
		this.v=v;
	}
}
