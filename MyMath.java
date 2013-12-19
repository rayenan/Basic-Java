/*
 *Name: Renee Fung
 *Student Number: V00778609
 *CSC 115
 *Assignment 4
 *My Math
*/ 

public class MyMath
{
	private double x; 
	private int n; 

	
	/*//////////////////////////////////////////*/
	/*/////CONSTRUCTORS + GETTERS & SETTERS/////*/
	/*//////////////////////////////////////////*/
	public MyMath()
	{
		this.x = 0; 
		this.n = 0; 
	}
	
	//Constructor for POWER
	public MyMath(double x, int n)
	{
		this.x = x; 
		//n has to be positive; otherwise return 0
		if(n >= 0) {
			this.n = n;
		} else {
			System.exit(0); 
		}
	}
	
	//Constructor for FACTORIAL
	public MyMath(double x)
	{
		if(x >= 0) {
			this.x = x;
		} else {
			System.exit(0);
		}
	}
	
	
	
	/*X*/
	//Mutator 
	public void setX(double x)
	{
		this.x = x; 
	}
	
	//Accessor
	public double getX()
	{
		return this.x; 
	}
	
	/*N*/
	//Mutator 
	public void setN(int n)
	{
		//n has to be positive; otherwise return 0
		if(n >= 0) {
			this.n = n; 
		} else {
			this.n = 0; 
		}
	}
	
	//Accessor 
	public int getN()
	{
		return this.n;
	}
	
	
	
	/*put EQUALS and TOSTRING*/
	//Equals method
	public boolean equals(MyMath other)
	{
		boolean same = false; 
		if( (this.x == other.x) && (this.n == other.n) ) {
			same = true; 
		}
		
		return same; 
	}
	
	//To String method
	public String toString()
	{
		String numbers = this.x + " " + this.n;
		return numbers; 
	}
	
	
	/*//////////////////////////////////////////*/
	/*///////////////////POWERS/////////////////*/
	/*//////////////////////////////////////////*/
	//Power One
	public void powerOne() 
	{

		double sum = 1;

		for(int i = 1; i <= this.n; i++) {
			sum *= x;
		}

		this.x = sum;

	}

	//Power Two
	public void powerTwo()
	{
		this.x = powerTwo(this.x, this.n);
	}
	
	private double powerTwo(double x, int n) 
	{

		//Base Case
		if(n == 0) {
			return 1;
		} 
		//Other Case
		else {
			return x * powerTwo(x, n-1);
		}

	}
	
	//Power Three
	public void powerThree()
	{
		this.x = powerThree(this.x, this.n);
	}
	
	private double powerThree(double x, int n) 
	{
		//Base Case
		if(n==0) {
			return 1;
		} 
		//Case 1
		else if (n>0 && (n%2)==0) {
			return (long)Math.pow(powerThree(x, n/2), 2);
		} 
		//Case 2
		else {
			return (long) x * (long)Math.pow(powerThree(x, n/2), 2);	
		}

	}
	
	
	/*//////////////////////////////////////////*/
	/*/////////////////FACTORIALS///////////////*/
	/*//////////////////////////////////////////*/
	//Factorial One
	public void factorialOne()
	{
		this.x = factorialOne( (int)this.x);
	}
	
	private int factorialOne(int x)
	{
		int result = 1; 
		
		for(int i = x; i > 1; i--) {
			result *= i; 
		}
		
		return result;
	}
	
	//Factorial Two
	public void factorialTwo()
	{
		this.x = factorialTwo( (int)this.x);
	}
	
	private int factorialTwo(int x) 
	{
		if(x == 0) {
			return 1;
		} else {
			return x * factorialTwo(x-1);
		}
	}
	
	
	/*//////////////////////////////////////////*/
	/*///////////////////COSINE/////////////////*/
	/*//////////////////////////////////////////*/
	public void cosineOne()
	{
		this.x = cosineOne(this.x, this.n+1);	
	}
	
	private double cosineOne(double x, int n)
	{
		for(int i = 0; i < n; i++) {
			MyMath value = new MyMath(2*i);
			value.factorialTwo();
			
			int factorial2N = (int) value.getX();
			double xPower = Math.pow(x, 2*i);
			
			if(n % 2 == 0) {
				this.x += xPower/factorial2N;
			} else {
				this.x -= xPower/factorial2N;
			}
			
		}
		
		return this.x;
	}
	
	public void cosineTwo() 
	{
		this.x = cosineTwo(this.x, this.n+1);
	}
	
	private double cosineTwo(double x, int n)
	{
		
		if(n == 0) {
			return 1; 
		} else {
			MyMath value = new MyMath(2*n);
			value.factorialTwo();
			
			int factorial2N = (int) value.getX();
			double xPower = Math.pow(x, 2*n);
			
			if(n % 2 == 0) {
				return cosineTwo(x, n-1) + xPower/factorial2N;
			} else {
				return cosineTwo(x, n-1) - xPower/factorial2N;
			}
		
		}
	}
	
	//Main for testing purposes 
	public static void main(String [] args)
	{
		MyMath calc = new MyMath(2, 2);
		calc.cosineTwo();
		System.out.println(calc.x);
	}
	
	
	
	


}	
