package model;

/* Class to get a chemical element */
public class Element {
	private String name;
	private String abbrev;
	private int atomNum;
	private int coefficient;
	
	public Element(String name, String abbrev, int atomNum, int coefficient){
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
	
	public int getCoefficient(){
		return coefficient;
	}
	
	public void setCoefficient(int coefficient){
		this.coefficient = coefficient;
	}
}
