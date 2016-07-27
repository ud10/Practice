package trees;
import java.util.*;
public class HeightOrder {
	public static ArrayList<Integer> result = new ArrayList<Integer>();
	private static class Person{
		public final int height;
		public final int frontCount;
		Person(int height, int frontCount){
			this.height = height;
			this.frontCount = frontCount;
		}
	}
	private static class TreeNode{
		int val;
		TreeNode left,right;
		public final Person person;
		public TreeNode(Person person){
			this.person = person;
			this.val = 1;
		}
	}
	public static void main(String args[]){
		//5 3 2 6 1 4; //0 1 2 0 3 2;
		//A : [ 86, 92, 49, 21, 62, 27, 90, 59 ]B : [ 2, 0, 0, 2, 0, 2, 1, 3 ]=> 49 62 21 27 92 90 59 86 
		ArrayList<Integer> height = new ArrayList<Integer>();
		ArrayList<Integer> infront = new ArrayList<Integer>();
		height.add(86);
		height.add(92);
		height.add(49);
		height.add(21);
		height.add(62);
		height.add(27);
		height.add(90);
		height.add(59);
		infront.add(2);infront.add(0);infront.add(0);infront.add(2);infront.add(0);infront.add(2);infront.add(1);infront.add(3);
		//ArrayList<Integer> result = new ArrayList<Integer>();
		result = order(height, infront);
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
	}
	private static void insert(TreeNode root, Person p){
		insert(root, p, p.frontCount);
	}
	private static void insert(TreeNode root, Person p, int val){
		if(val < root.val){
			if(root.left == null)
				root.left = new TreeNode(p);
			else
				insert(root.left, p, val);
			root.val++;
		}
		else{
			if(root.right == null)
				root.right = new TreeNode(p);
			else
				insert(root.right, p, val - root.val);
			
		}
	}
	private static ArrayList<Integer> inOrder(TreeNode p){
		if(p==null)
			return result;
		inOrder(p.left);
		result.add(p.person.height);
		inOrder(p.right);
		return result;
	}
	public static ArrayList<Integer> order(ArrayList<Integer> height, ArrayList<Integer> infront){
		ArrayList<Person> persons = new ArrayList<Person>();
		for(int i=0;i<height.size();i++){
			Person p = new Person(height.get(i), infront.get(i));
			persons.add(p);
		}
		Collections.sort(persons, (p1,p2)->{return Integer.compare(p2.height, p1.height);});
		TreeNode root = new TreeNode(persons.get(0));
		for(int i=1;i<persons.size();i++){
			insert(root, persons.get(i));
		}
		return inOrder(root);
	}
}
