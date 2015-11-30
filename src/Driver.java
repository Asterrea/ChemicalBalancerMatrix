import java.util.Scanner;
import model.Elements;

public class Driver {
	
	public static void main(String[] args) {
		String input;
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter chemical equation: ");
		input = sc.next();
		sc.close();
		
		System.out.println(Elements.valueOf("B").getElementName());
	}

}
