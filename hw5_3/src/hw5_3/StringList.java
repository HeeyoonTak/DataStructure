package hw5_3;

public class StringList {
	private String[] array;
	private int size;
	
	public StringList(){
		array=new String[10];
		size=0; // �迭�� ����
	}
	public void insert(int index, String str){
		if(index>array.length-1) {
			System.out.println("���� ũ�� ���� �Ѿ���ϴ�.");
		}
		array[index]=str;
		if(size<index){
			size=index+1;
		}
	}
	
	public void delete(String str){
		for(int i=0; i<size; i++){
			if(str.equals(array[i])){
				for(int j=i; j<size-1;j++){
					array[j]=array[j+1];
				}
				size--;
				break;
			}
			else {
				continue;
			}
		}
	}
	public String search(int index){
		return array[index];
	}
	public int sizeSearch(){
		return size;
	}
	public String toString(){
		String aL="";
		for(int i=0; i<size; i++){
			aL+=array[i]+" ";
		}
		return "����Ʈ ����: "+aL;
	}
}
