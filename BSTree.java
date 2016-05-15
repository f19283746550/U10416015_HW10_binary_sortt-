import java.util.Arrays;
import java.util.Scanner;
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}
public class BSTree {
	public TreeNode head;
	public BSTree() { head = null; }
	public void insertBSTreeNode(int data) {
		if ( head == null ) { 
			head = new TreeNode(data);
			return;
		}
		TreeNode current = head;
		while (true) {
			if ( data < current.data ) {
				if ( current.left == null ) {
					current.left = new TreeNode(data);
					return;
				}
				else  current = current.left;
			}
			else { 
				if ( current.right == null ) {
					current.right = new TreeNode(data);
					return;
				}
				else  current = current.right;
			}
		}
	}
	public void inOrder(TreeNode node) {
		if ( node != null ) {  
			inOrder(node.left);
			System.out.print("["+node.data+"]");
			inOrder(node.right);
		}
	}
	public void preOrder(TreeNode node) {
		if ( node != null ) { 
			System.out.print("["+node.data+"]"); 
			preOrder(node.left);   
			preOrder(node.right);
		}
	}
	public void postOrder(TreeNode node) {
		if ( node != null ) {  
			postOrder(node.left);
			postOrder(node.right);
			System.out.print("["+node.data+"]");
		}
	}
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		int[] array= {/* 5, 6, 4, 8, 2, 3, 7, 1, 9 */};
		System.out.println("Please input Integer");
		while(input.hasNext()) {
			int x=input.nextInt();
			array = addElement(array, x);
			BSTree obj = new BSTree();
			System.out.print("Original Array:");
			for (int i = 0; i < array.length; i++ ) {
				System.out.print("["+array[i]+"]");
				obj.insertBSTreeNode(array[i]);
			}
			System.out.println();
			System.out.print("InOrder:");
			obj.inOrder(obj.head);
			System.out.println();
			System.out.print("PreOrder:");
			obj.preOrder(obj.head);
			System.out.println();
			System.out.print("PostOrder:");
			obj.postOrder(obj.head);
			System.out.println();
		}
	}
	static int[] addElement(int[] a, int e) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==e) {
				return a;
			}
		}
		a  = Arrays.copyOf(a, a.length + 1);
		a[a.length - 1] = e;
		return a;
	}
}
