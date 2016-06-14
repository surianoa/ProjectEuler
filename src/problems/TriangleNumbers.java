package problems;

public class TriangleNumbers {
	
	public static long findTriangleNumberWithNDivisors(int numDivisors){
		int minValue = (int) Math.pow((numDivisors-2), 2) + 1;
		
		int n = 2;
		long num = findNthTriangleNum(n);
		
		while(num < minValue){
			n++;
			num = findNthTriangleNum(n);
		}
		
		int divisors = numberOfDivisors(num);
		
		while(divisors < numDivisors){
			n++;
			num = findNthTriangleNum(n);
			divisors = numberOfDivisors(num);
		}
		
		return num;
		
	}
	
	public static int findNthTriangleNum(int n){
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
		
		int count = 2;
		
		for(int i = 2; i<=(int)Math.sqrt(num); i++){
			if(num%i==0){
				if(i == Math.sqrt(num)){
					count++;
				}else{
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
