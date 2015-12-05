package model;

public class EuclideanAlgorithm {

	//Get the GCF of two numbers using Euclidean Algorithm
	public static int getGCF(int a, int b) {
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		else {
			return getGCF(b,a%b);
		}
	}
	
	//Get the LCM of two numbers
	public static int getLCM(int a, int b) {
		return (a*b)/getGCF(a,b);
	}
}
