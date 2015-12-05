import java.util.Scanner;

import model.Equation;

public class Driver {
	
	public static void main(String[] args) {
		String leftInput, rightInput;
		String element;
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter left equation: ");
		leftInput = sc.next();
		System.out.print("Enter right equation: ");
		rightInput = sc.next();
		sc.close();
		
		new Equation(leftInput, rightInput);
		
		/*
		element = null;
		for(int i = 0; i < input.length(); i++){
			if (Character.isUpperCase(input.charAt(i))){
				element = "" + input.charAt(i);
			} else{
				element += input.charAt(i);
			}
			
			// Check if next character is upper case 
			if (i+1 < input.length()){
				if (Character.isUpperCase(input.charAt(i+1))){
					System.out.println("Element Name: " + Elements.valueOf(element.toUpperCase()).getElementName());
					System.out.println("Element Abbreviation: " + Elements.valueOf(element.toUpperCase()).getElementAbbrev());
					System.out.println("Atomic Number: " + Elements.valueOf(element.toUpperCase()).getAtomicNumber());
				}
			} else{
				System.out.println("Element Name: " + Elements.valueOf(element.toUpperCase()).getElementName());
				System.out.println("Element Abbreviation: " + Elements.valueOf(element.toUpperCase()).getElementAbbrev());
				System.out.println("Atomic Number: " + Elements.valueOf(element.toUpperCase()).getAtomicNumber());
			}
		}
		
		//System.out.println(Elements.valueOf("B").getElementName());
		 */
		
		
	}

}
