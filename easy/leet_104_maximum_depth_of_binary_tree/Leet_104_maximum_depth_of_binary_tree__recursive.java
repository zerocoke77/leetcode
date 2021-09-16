package leet_104_maximum_depth_of_binary_tree;

//	https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class Leet_104_maximum_depth_of_binary_tree__recursive {
	public static Object[] arr;
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	public TreeNode() {}
    	public TreeNode(int val) { this.val = val; }
    	public TreeNode(int val, TreeNode left, TreeNode right) {
    		this.val = val;
    		this.left = left;
    		this.right = right;
    	}
    }
    
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int depth = 0;
		
		if(root.left != null) {
			depth = Math.max(depth, maxDepth(root.left));
		}
		
		if(root.right != null) {
			depth = Math.max(depth, maxDepth(root.right));
		}
		
        return depth + 1;
    }
	
	public TreeNode converter(int preIndex) {
		if(preIndex > arr.length) return null;
		
		int index = preIndex-1;
		if(arr[index] instanceof Integer) {
			TreeNode left = converter(2*preIndex);
			TreeNode right = converter(2*preIndex+1);
			TreeNode treeNode = new TreeNode((int)arr[index], left, right);
			return treeNode;
		}
		
		return null;
	}
    
	public static void main(String args[]) {
		Leet_104_maximum_depth_of_binary_tree__recursive inst = new Leet_104_maximum_depth_of_binary_tree__recursive();
		arr = new Object[] { 3,9,20,null,null,15,7 };
//		arr = new Object[] { 1,null,2 };
//		arr = new Object[] { };
//		arr = new Object[] { 0 };
		TreeNode root = inst.converter(1);
		int depth = inst.maxDepth(root);
		System.out.println(depth);
	}
}
