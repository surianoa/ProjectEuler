package problems;

public class TriangleNumbers {
	
	/*
	 * Code solution for Problem 12 on Project Euler. 
	 * Original problem posted here: https://projecteuler.net/problem=12
	 * Alex Suriano - 6/13/16
	 */
	
	
	public static long findTriangleNumberWithNDivisors(int numDivisors){
		/*
		 * This is the lowest value that is possible to have numDivisors divisors. Every number greater than 1 is divisible
		 * by 1 and itself, hence the -2. By squaring that value, we can ensure that the function numberOfDivisors will check 
		 * 2 to Math.sqrt(minValue) (in our problem 2 to 498. 498+ 2 (implied divisors of 1 and the number itself) = 500.)  
		 */
		int minValue = (int) Math.pow((numDivisors-2), 2) + 1;
		
		int n = 2;
		long num = findNthTriangleNum(n);
		
		//find the smallest triangle number that is >= the minValue
		while(num < minValue){
			n++;
			num = findNthTriangleNum(n);
		}
		
		//see how many divisors this triangle number has
		int divisors = numberOfDivisors(num);
		
		//if it is less than numDivisors, check the next Triangle number until you find one that has >= numDivisor divisors
		while(divisors < numDivisors){
			n++;
			num = findNthTriangleNum(n);
			divisors = numberOfDivisors(num);
		}
		
		return num;
		
	}
	
	public static int findNthTriangleNum(int n){
		/*
		 * If you look at the given triangle numbers, you can see they follow the below pattern. This way we can calculate the Nth Triangle number in O(1). 
		 */
		if(n>1){
			if(n%2==0){
				return ((n/2)*(n+1));
			}
			else{
				return (((int)n/2)+1)*n;
			}
		}
		return 1;
	}
	
	
	private static int numberOfDivisors(long num) {
		
		if(num<2){
			return 1;
		}
		
		//Initialized to 2 because every number greater than 1 is divisible by 1 and itself
		int count = 2;
		
		for(int i = 2; i<=(int)Math.sqrt(num); i++){
			if(num%i==0){
				//If i is the square root of num, only add one to avoid double counting the square
				if(i == Math.sqrt(num)){
					count++;
				}else{
					//increment by 2 to account for i and num/i
					count+=2;
				}				
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		//test findNthTriangleNumber method to make sure returning same values as given in problem
		for(int i = 1; i<11; i++){
			System.out.println(findNthTriangleNum(i));
		}
		
		//test numberOfDivisors method to compare with given values
		for(int i = 1; i < 8; i++){
			System.out.println(numberOfDivisors(findNthTriangleNum(i)));
		}
		
		//test given test case
		int tri = 5;
		System.out.println("The triangle number with >= " + tri + " divisors is " + findTriangleNumberWithNDivisors(tri));
		
		
		//get solution
		tri = 500;
		long start = System.currentTimeMillis();
		System.out.println("The triangle number with >= " + tri + " divisors is " + findTriangleNumberWithNDivisors(tri));
		long stop = System.currentTimeMillis();
		
		System.out.println("The runtime of this mehtod is " + (stop - start));

	}

}
