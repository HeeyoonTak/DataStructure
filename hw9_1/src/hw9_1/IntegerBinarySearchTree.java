package hw9_1;

public class IntegerBinarySearchTree {
	TreeNode root;
	public void add(int key){
		root=addKey(root,key);
	}
	public TreeNode addKey(TreeNode p,int key){
		if(p==null){
			TreeNode newNode=new TreeNode(key);
			System.out.print(newNode.key+":"+newNode.freq+" ");
			System.out.println();
			return newNode;
			
		}
		else if(key<p.key){
			p.left=addKey(p.right,key);
			System.out.println();
			return p;
		}
		else if(key>p.key){
			p.right=addKey(p.right,key);
			System.out.println();
			return p;
		}
		else{
			p.freq++;
			System.out.println("���� �����մϴ�."+p.freq+" ");
			System.out.println();
			return p;
		}
	}
	public void inorder() {
		inorder(root);
		System.out.println();
	}
	private void inorder(TreeNode p) {
		if(p!=null){
		inorder(p.left);
		System.out.print("��:"+p.key+" �󵵼�:"+p.freq);
		inorder(p.right);
		}
	}
}
