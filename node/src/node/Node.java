package node;


public class Node {
	// ��� ���� ����
	int v;
	Node link;
	// ������
	public Node(int i) {
		this.v=i;
	}
	// getter ����
	public int getV() {
		return v;
	}
	// setter ����
	public void setV(int v) {
		this.v=v;
	}
}
