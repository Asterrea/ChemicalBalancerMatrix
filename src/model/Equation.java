package model;

import java.util.ArrayList;

/* Get the equation based on the given inputs */
public class Equation {
	
	private String leftEquation;
	private String rightEquation;
	private ArrayList<Compound> compounds = new ArrayList<Compound>();	// Get chemical compounds
	private ArrayList<Element> elements = new ArrayList<Element>(); // Get all elements from the equation
	
	/* Note: Right equation has negative coefficients */
	public Equation(String leftEquation, String rightEquation){
		this.leftEquation = leftEquation;
		this.rightEquation = rightEquation;
		storeCompounds(leftEquation, "LEFT");
		storeCompounds(rightEquation, "RIGHT");
	}
	
	public void storeCompounds(String equation, String side){
		String strCompound = "";
		Compound compound;
		
		/* Get each compound */
		for (int i = 0; i < equation.length(); i++){
			if (equation.charAt(i) != ' '){
				if (equation.charAt(i) == '+'){
					compound = new Compound(strCompound);
					
					/* Invert coefficients if the side of the equation is at the right side */
					if(side.equalsIgnoreCase("RIGHT")){
						compound.negateCoefficients();
					}
					
					compounds.add(compound);
					strCompound = "";
				} else{
					strCompound += equation.charAt(i);
				}
			}
		}
		
		/* Get the last compound */
		compound = new Compound(strCompound);
		
		if(side.equalsIgnoreCase("RIGHT")){
			compound.negateCoefficients();
		}
		
		compounds.add(compound);
	}
	
	/* Get all elements in the equation */
	public void getAllElements(){
		
	}
	
}
