package model;

public class Element {
	private String name;
	private String abbrev;
	private int atomNum;
	
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
}
