/**
 * 
 */
package temp;

/**
 * @author uditgupta
 * Jun 10, 2016 9:54:58 AM
 */
public class Test {

	public static void main(String[] args) {
		try{
			System.out.println("A");
		}
		catch(Exception e){
			System.out.println("B");
		}
		finally{
			System.out.println("C");
		}
		System.out.println("D");
	}

}
