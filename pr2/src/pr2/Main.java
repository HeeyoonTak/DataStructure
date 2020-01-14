package pr2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("Ź����"); // �ڽ��� �̸��� ����Ѵ�.
		Scanner scan = new Scanner(System.in);

		FriendList friendList = new FriendList();

		String name=null;
		int number=0;
		try{
			System.out.print("��ȣ �Է�: ");
			number = scan.nextInt();
			name = friendList.get(number);
			System.out.println(number + "���� ��ϵ� ģ���� " + name);

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("�Է��� ��ȣ�� ������ ������ϴ�.");
		}catch(InputMismatchException e){
			System.out.println("��ȣ�� �������� �Է��ؾ� �մϴ�.");
		}

	}

}
class FriendList {
	private String[] list = {"kim", "park", "lee"};
	public String get(int number) {
		return list[number-1];
	}
}
