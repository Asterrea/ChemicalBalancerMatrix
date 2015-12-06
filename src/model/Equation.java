package model;

import java.util.ArrayList;

/* Get the equation based on the given inputs */
public class Equation {
	
	private String leftEquation;
	private String rightEquation;
	private ArrayList<Compound> compounds = new ArrayList<Compound>();	// Get chemical compounds
	private ArrayList<Element> elements = new ArrayList<Element>(); // Get all elements from the equation
	private double[][] matrix;
	private double[][] newMatrix;
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
					compound = new Compound(strCompound, side);
					
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
		compound = new Compound(strCompound, side);
		
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
		double highest = -1;
		double compare = 0;
		int highestCol = 0;
		int[] values = null;
		int gcf = 0;
		boolean toGCF = false;
		
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
		
		/* Eliminate the row with the highest value */
		if (elements.size() >= compounds.size()){
			newMatrix = new double[elements.size() - 1][compounds.size() + 1];
			
			for (int i = 0; i < compounds.size(); i++){
				for (int j = 0; j < elements.size(); j++){
					if (matrix[j][i] > highest){
						highest = matrix[j][i];
						highestCol = j;
					}
				}
			}
			
			for (int i = 0; i < compounds.size() + 1; i++){
				for (int j = 0; j < elements.size() - 1; j++){
					if (j < highestCol){
						newMatrix[j][i] = matrix[j][i];
					}
					else {
						newMatrix[j][i] = matrix[j+1][i];
					}
				}
			}
			matrix = newMatrix;
		}
		
		/* Perform Gauss Jordan Reduction */
		operations = new Matrix(matrix);
		operations.printMatrix();
		System.out.println();
		matrix = operations.reduceMatrix();
		operations.printMatrix();
		
		/* Get the values */
		if (elements.size() >= compounds.size()){
			for(int i = 0; i < elements.size() - 1; i++){
				compounds.get(i).setMultiplier(matrix[i][compounds.size()-1] * -1);
				
				values = new int[elements.size()-1];
				if (compounds.get(i).getMultiplier()%1 == 0){
					values[i] = (int) compounds.get(i).getMultiplier();
				} else {
					values[i] = (int) (compounds.get(i).getMultiplier() * 10);
					toGCF = true;
				}	
			}
			compounds.get(compounds.size()-1).setMultiplier(1);
		} else {
			for(int i = 0; i < elements.size(); i++){
				compounds.get(i).setMultiplier(matrix[i][compounds.size()-1] * -1);
				
				values = new int[elements.size()];
				if (compounds.get(i).getMultiplier()%1 == 0){
					values[i] = (int) compounds.get(i).getMultiplier();
				} else {
					values[i] = (int) (compounds.get(i).getMultiplier() * 10);
					toGCF = true;
				}
			}
			compounds.get(elements.size()).setMultiplier(1);
		}
		
		if (toGCF == true){
			// Get GCF
			for(int i = 1; i < values.length; i++){
				if (i == 1){
					gcf = EuclideanAlgorithm.getGCF(values[i-1], values[i]);
				} else {
					gcf = EuclideanAlgorithm.getGCF(gcf, values[i]);
				}
			}
			
			// Multiply to the answer
			for(int i = 0; i < compounds.size(); i++){
				compounds.get(i).setMultiplier(compounds.get(i).getMultiplier() * gcf);
			}
		}
		System.out.println(getLeftEquation() + " = " + getRightEquation());
	}
	
	public String getLeftEquation(){
		String equation = "";
		for (int i = 0; i < compounds.size(); i++){
			if (compounds.get(i).getSide().equalsIgnoreCase("LEFT")){
				if (compounds.get(i).getMultiplier() == 1){
					equation += compounds.get(i).getCompound();
				} else {
					equation += ((int) compounds.get(i).getMultiplier()) + compounds.get(i).getCompound();
				}
				if (!(compounds.get(i+1).getSide().equalsIgnoreCase("RIGHT"))){
					equation += " + ";
				}
			}
		}
		
		return equation;
	}
	
	public String getRightEquation(){
		String equation = "";
		for (int i = 0; i < compounds.size(); i++){
			if (compounds.get(i).getSide().equalsIgnoreCase("RIGHT")){
				if (compounds.get(i).getMultiplier() == 1){
					equation += compounds.get(i).getCompound();
				} else {
					equation += ((int) compounds.get(i).getMultiplier()) + compounds.get(i).getCompound();
				}
				if (i < compounds.size()-1){
					equation += " + ";
				}
			}
		}
		
		return equation;
	}
}
