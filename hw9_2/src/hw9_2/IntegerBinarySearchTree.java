package hw9_2;


public class IntegerBinarySearchTree {
	TreeNode root;
	public void add(int key){
		root=addKey(root,key);
	}
	private TreeNode addKey(TreeNode p,int key){
		if(p==null){
			TreeNode newNode=new TreeNode(key);
			newNode.left=null;
			newNode.right=null;
			System.out.print(newNode.key+":"+newNode.freq+" ");
			System.out.println();
			return newNode;
			
		}
		else if(key<p.key){
			p.left=addKey(p.left,key);
			return p;
		}
		else if(key>p.key){
			p.right=addKey(p.right,key);
			return p;
		}
		else{
			p.freq++;
			System.out.println("값이 존재합니다. [빈도수:"+p.freq+"] ");
			return p;
		}
	}
	public void inorder() {
		inorder(root);
		System.out.println();
	}
	private void inorder(TreeNode root) {
		if(root!=null){
		inorder(root.left);
		System.out.print("[값:"+root.key+" 빈도수:"+root.freq+"] ");
		inorder(root.right);
		}
		else{
			System.out.println("노드가 비었습니다.");
		}
	}
	public boolean remove(int key){
		TreeNode p = root;
		TreeNode parent=p;
		
		while(p.key!=key){
			parent=p;
			if(p.key>key){
				p=p.left;
			}
			else{
				p=p.right;
			}
			if(p==null){
				System.out.println("삭제 할 노드가 비어있습니다.");
			}
		}
		//자식이 없을 때
		if(p.left==null && p.right==null){
			if(p==root){
				root=null;
				System.out.println("삭제성공");
			}
			else if(p==parent.left){
				parent.left=null;
				System.out.println("삭제성공");
			}
			else{
				parent.right=null;
				System.out.println("삭제성공");
			}
		}
		//자식이 하나 일 때
		else if(p.left==null || p.right==null){
			//오른쪽만 존재
			if(p.left==null){
				if(p==root){
					root=p.right;
					System.out.println("삭제성공");
				}
				else if(p==parent.left){
					parent.left=p.right;
					System.out.println("삭제성공");
				}
				else{
					parent.right=p.right;
					System.out.println("삭제성공");
				}
			}
			//왼쪽만 존재
			else if(p.right==null){
				if(p==root){
					root=p.left;
					System.out.println("삭제성공");
				}
				else if(p==parent.left){
					parent.left=p.left;
					System.out.println("삭제성공");
				}
				else{
					parent.right=p.left;
					System.out.println("삭제성공");
				}
			}
		}
		//자식이 둘 일 때
		else{
			TreeNode q = minNode(p);
			if(p==root){
				root=q;
				System.out.println("삭제성공");
			}
			else if(p==parent.left){
				parent.left=q;
				System.out.println("삭제성공");
			}
			else{
				parent.right=q;
				System.out.println("삭제성공");
			}
			q.left=p.left;
		}
		return true;
	}
	private TreeNode minNode(TreeNode delete){
		TreeNode parent=delete;
		TreeNode p=parent.right;
		while(p.left!=null){
			parent=p;
			p=p.left;
		}
		if(p!=delete.right){
			parent.left=p.right;
			p.right=delete.right;
		}
		return p;
	}
	/*
	  static Node maxNode(Node n) {
    Node max = n;
    while (max.right != null) {
      max = max.right;
    }
    return max;
  }
	 */
	public void search(int key){
		TreeNode p = searchKey(key);
		if(p!=null){
			System.out.println("값:"+p.key+" 빈도수:"+p.freq);
		}
		else{
			System.out.println("검색 실패!!!");
		}
	}
	private TreeNode searchKey(int key){
		TreeNode p = root;
		while(p!=null){
			if(key<p.key){
				p=p.left;
			}
			else if(key>p.key){
				p=p.right;
			}
			else{
				return p;
			}
		}
		return p;
		
	}
}
