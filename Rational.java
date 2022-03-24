/*
 * Andrew DeSimone
 */
public class Rational 
{

	//declare instance variables
	private int numerator;
	private int denominator;
	
	//default constructor
	public Rational()
	{
		numerator = 0;
		denominator = 1;
	}
	
	//constructor
	public Rational(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	//print the rational number as a/b
	public void printRational()
	{
		System.out.println(numerator + " / " + denominator);
	}
	
	//converts rational class from integer to double
	public double toDouble()
	{
		return (numerator * 1.0) / denominator;
	}
	
	//returns string of rational class in a/b form
	public String toString()
	{
		return numerator + " / " + denominator;
	}
	
	//reverses sign of rational
	public void negate()
	{
		numerator *= -1;
	}
	
	//returns rational in b/a form
	public void invert()
	{
		int temp = denominator ;
		denominator = numerator;
		numerator = temp;
	}
	
	//simplifies rational class
	public Rational reduce()
	{
		int gcf = euclid(numerator, denominator);
		return new Rational(numerator / gcf, denominator / gcf);
	}
	
	//adds two rational numbers
	public Rational add(Rational other)
	{
		int den = this.denominator * other.getDenominator();
		int num = this.numerator * other.getDenominator() + this.denominator * other.getNumerator();
		return new Rational(num,den).reduce();
	}
	
	//multiplies two rational numbers
	public Rational multiply(Rational other)
	{
		int den = this.denominator*other.getDenominator();
		int num = this.numerator*other.getNumerator();
		return new Rational(num,den).reduce();
	}
	
	//returns numerator
	public int getNumerator() 
	{
		return numerator;
	}

	//changes value of numerator
	public void setNumerator(int numerator) 
	{
		this.numerator = numerator;
	}

	//returns denominator
	public int getDenominator() 
	{
		return denominator;
	}

	//changes value of denominator
	public void setDenominator(int denominator) 
	{
		this.denominator = denominator;
	}

	//recursive method to find gcf
	private static int euclid(int a, int b)
	{
		if(a == 0)
		{
			return b;
		}
		else if(b == 0)
		{
			return a;
		}
		else
		{
			return euclid(b, a % b);
		}
	}
	
}