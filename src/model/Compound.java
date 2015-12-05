package model;

import java.util.ArrayList;

/* Get each chemical compound */
public class Compound {
	
	ArrayList<Element> elements = new ArrayList<Element>();
	
	public Compound(String compound){
		storeElements(compound);
	}
	
	public void storeElements(String compound){
		String element = "";
		int coefficient = 0;
		
		/* Get first character of the string */
		element += compound.charAt(0);
		
		/* Get each element */
		for (int i = 1; i < compound.length(); i++){
			/* Store element */
			if (Character.isUpperCase(compound.charAt(i))){
				/* Change coefficient to 1 if the element doesn't have any number (e.g. HCl) */
				if (coefficient == 0){
					coefficient = 1;
				}
				
				/* Store element with the corresponding constant */
				elements.add(new Element(Elements.valueOf(element.toUpperCase()).getElementName(), Elements.valueOf(element.toUpperCase()).getElementAbbrev(), Elements.valueOf(element.toUpperCase()).getAtomicNumber(), coefficient));
				
				/* Get new element */
				element = "" + compound.charAt(i);
				coefficient = 0;
			} else if (compound.charAt(i) >= '0' && compound.charAt(i) <= '9'){
				coefficient = (coefficient * 10) + Character.getNumericValue(compound.charAt(i));
			} else {
				element += compound.charAt(i);
			}
		}
		
		/* Get last element */
		if (coefficient == 0){
			coefficient = 1;
		}
		elements.add(new Element(Elements.valueOf(element.toUpperCase()).getElementName(), Elements.valueOf(element.toUpperCase()).getElementAbbrev(), Elements.valueOf(element.toUpperCase()).getAtomicNumber(), coefficient));
		
	}
	
	public void negateCoefficients(){
		for (int i = 0; i < elements.size(); i++){
			elements.get(i).setCoefficient(elements.get(i).getCoefficient() * -1);
		}
	}
	
}
