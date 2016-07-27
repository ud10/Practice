package trees;

/**
 * @author uditgupta
 * May 28, 2016 10:19:58 PM
 */
public class SerializeDeserialize {
	/*
	 * Preorder serialization and de-serialization
	 */
	static int index = 0;
	static int index1 = 0;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		
		int[] arr = new int[20];
		serialize(root, arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		@SuppressWarnings("unused")
		TreeNode node = deserialize(arr);
	}
	
	private static void serialize(TreeNode root, int[] arr){
		if(root == null){
			arr[index] = -1;
			index++;
			return;
		}
		arr[index] = root.val;
		index++;
		serialize(root.left, arr);
		serialize(root.right, arr);
	}
	
	private static TreeNode deserialize(int[] arr){
		if(arr.length == index1 || arr[index1] == -1){
			index1++;
			return null;
		}
		TreeNode root = new TreeNode(arr[index1]);
		index1++;
		root.left = deserialize(arr);
		root.right = deserialize(arr);
		
		return root;
	}
	
}
