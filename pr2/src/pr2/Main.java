package pr2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("탁희윤"); // 자신의 이름을 출력한다.
		Scanner scan = new Scanner(System.in);

		FriendList friendList = new FriendList();

		String name=null;
		int number=0;
		try{
			System.out.print("번호 입력: ");
			number = scan.nextInt();
			name = friendList.get(number);
			System.out.println(number + "번에 등록된 친구는 " + name);

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("입력한 번호가 범위를 벗어났습니다.");
		}catch(InputMismatchException e){
			System.out.println("번호로 정수값을 입력해야 합니다.");
		}

	}

}
class FriendList {
	private String[] list = {"kim", "park", "lee"};
	public String get(int number) {
		return list[number-1];
	}
}
