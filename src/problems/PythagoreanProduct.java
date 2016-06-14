package problems;

public class PythagoreanProduct {

	/*
	 * Code solution for Problem 9 on Project Euler. 
	 * Original problem found here: https://projecteuler.net/problem=9
	 * Alex Suriano - 6/10/16
	 */
	
	
	public static int findPythagoreanProduct(int n){
		/*
		 * Since we know that we can use sides A and B to calculate C, we only need 2 for loops. 
		 * A side of a triangle can't be larger than half of the perimeter (or else it would be a line)
		 */
		for(int a= 1; a<(n/2); a++){
			//
			for(int b = ((n/2)-a); b<n/2; b++ ){
				//c = sqrt(a^2 + b^2) via Pythagorean Theorem
				double term = (a+b+Math.sqrt((a*a)+(b*b)));
				//if this equals the value passed to the function, we know we have the correct values of A and B
				if(term == n){
					//calculate the value of C and return the product
					int c = n-(a+b);
					return a*b*c;
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		//test the base case
		int py = 12;		
		System.out.println("The pythagorean product of " + py + " is "+ findPythagoreanProduct(py));
		
		//find solution
		py = 1000;		
		System.out.println("The pythagorean product of " + py + " is "+ findPythagoreanProduct(py));

	}

}
