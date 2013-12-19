public class CauseException 
{
	public static void main(String[] args)
	{
		//int x = 1 / 0;
		//double x = 1.0 / 0.0;
		//System.out.println(x);
		
		System.out.println(factorial(-7));
	}
	
	//pre: n>=0
	//post: returns n factorial (n!)
	public static int factorial(int n)
	{
		if(n<0) {
			throw new IllegalArgumentException("negative n: " + n);
		}
		
		int product = 1;
		for (int i=2; i<=n; i++)
		{
			product *= i;
		}
		
		return product;
	}

}
