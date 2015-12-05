package model;

public class EuclideanAlgorithm {

	public static int getGCF(int a, int b) {
		if(a == 0)
			return b;
		else if(b == 0)
			return a;
		else {
			return getGCF(b,a%b);
		}
	}
}
