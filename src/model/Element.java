package model;

/* Class to get a chemical element */
public class Element {
	private String name;
	private String abbrev;
	private int atomNum;
	private double coefficient;
	
	public Element(String name, String abbrev, int atomNum, double coefficient){
		this.name = name;
		this.abbrev = abbrev;
		this.atomNum = atomNum;
		this.coefficient = coefficient;
	}
	
	public String getElementName(){
		return name;
	}
	
	public void setElementName(String name){
		this.name = name;
	}
	
	public String getElementAbbrev(){
		return abbrev;
	}
	
	public void setElementAbbrev(String abbrev){
		this.abbrev = abbrev;
	}
	
	public int getAtomicNum(){
		return atomNum;
	}
	
	public void setAtomicNum(int atomNum){
		this.atomNum = atomNum;
	}
	
	public double getCoefficient(){
		return coefficient;
	}
	
	public void setCoefficient(double coefficient){
		this.coefficient = coefficient;
	}
	
	public boolean isEqual(String abbrev){
		return this.abbrev.equalsIgnoreCase(abbrev) ? true : false;
	}
}
