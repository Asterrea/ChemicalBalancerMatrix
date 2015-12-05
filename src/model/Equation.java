package model;

import java.util.ArrayList;

/* Get the equation based on the given inputs */
public class Equation {
	
	private String leftEquation;
	private String rightEquation;
	private ArrayList<Compound> compounds = new ArrayList<Compound>();	// Get chemical compounds
	private ArrayList<Element> elements = new ArrayList<Element>(); // Get all elements from the equation
	private double[][] matrix;
	private Matrix operations;
	
	/* Note: Right equation has negative coefficients */
	public Equation(String leftEquation, String rightEquation){
		this.leftEquation = leftEquation;
		this.rightEquation = rightEquation;
		storeCompounds(leftEquation, "LEFT");
		storeCompounds(rightEquation, "RIGHT");
		getAllElements();
		toMatrix();
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
		boolean unique = false;
		/* Check all compounds for elements */
		for (int i = 0; i < compounds.size(); i++){
			/* Check each elements in a compound */
			for (int j = 0; j < compounds.get(i).getCompoundElements().size(); j++){
				if (elements.size() == 0){
					elements.add(compounds.get(i).getCompoundElements().get(j));
				} else{
					unique = true;
					for (int k = 0; k < elements.size(); k++){
						if (compounds.get(i).getCompoundElements().get(j).isEqual(elements.get(k).getElementAbbrev())){
							unique = false;
						}
					}
					if(unique == true){
						elements.add(compounds.get(i).getCompoundElements().get(j));
					}
				}
			}
		}
	}
	
	/* Make a matrix of n x n+1 */
	public void toMatrix(){
		matrix = new double[elements.size()][compounds.size() + 1];
		boolean exist = false;
		int index = 0;
		
		// Column
		for (int i = 0; i < compounds.size() + 1; i++){
			
			if (i == compounds.size()){
				for (int j = 0; j < elements.size(); j++){
					matrix[j][i] = 0;
				}
			} else {
				//Row
				for (int j = 0; j < elements.size(); j++){
					for (int k = 0; k < compounds.get(i).getCompoundElements().size(); k++){
						if (compounds.get(i).getCompoundElements().get(k).isEqual(elements.get(j).getElementAbbrev())){
							exist = true;
							index = k;
						}
					}
					if (exist){
						matrix[j][i] = compounds.get(i).getCompoundElements().get(index).getCoefficient();
						exist = false;
					} else {
						matrix[j][i] = 0;
					}
				}
			}
		}
		
		/* Perform Gauss Jordan Reduction */
		operations = new Matrix(matrix);
		operations.reduceMatrix();
		operations.printMatrix();
		
	}
	
}
