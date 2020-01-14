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
			System.out.println("���� �����մϴ�. [�󵵼�:"+p.freq+"] ");
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
		System.out.print("[��:"+root.key+" �󵵼�:"+root.freq+"] ");
		inorder(root.right);
		}
		else{
			System.out.println("��尡 ������ϴ�.");
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
				System.out.println("���� �� ��尡 ����ֽ��ϴ�.");
			}
		}
		//�ڽ��� ���� ��
		if(p.left==null && p.right==null){
			if(p==root){
				root=null;
				System.out.println("��������");
			}
			else if(p==parent.left){
				parent.left=null;
				System.out.println("��������");
			}
			else{
				parent.right=null;
				System.out.println("��������");
			}
		}
		//�ڽ��� �ϳ� �� ��
		else if(p.left==null || p.right==null){
			//�����ʸ� ����
			if(p.left==null){
				if(p==root){
					root=p.right;
					System.out.println("��������");
				}
				else if(p==parent.left){
					parent.left=p.right;
					System.out.println("��������");
				}
				else{
					parent.right=p.right;
					System.out.println("��������");
				}
			}
			//���ʸ� ����
			else if(p.right==null){
				if(p==root){
					root=p.left;
					System.out.println("��������");
				}
				else if(p==parent.left){
					parent.left=p.left;
					System.out.println("��������");
				}
				else{
					parent.right=p.left;
					System.out.println("��������");
				}
			}
		}
		//�ڽ��� �� �� ��
		else{
			TreeNode q = minNode(p);
			if(p==root){
				root=q;
				System.out.println("��������");
			}
			else if(p==parent.left){
				parent.left=q;
				System.out.println("��������");
			}
			else{
				parent.right=q;
				System.out.println("��������");
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
			System.out.println("��:"+p.key+" �󵵼�:"+p.freq);
		}
		else{
			System.out.println("�˻� ����!!!");
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
