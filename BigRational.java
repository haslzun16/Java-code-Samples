import java.math.BigInteger;

public final class BigRational implements Comparable<BigRational>
{
    // creating the value of zero and one and negative one
    public final static BigRational ZERO = valueOf(0);
    public final static BigRational ONE = valueOf(1);
    public final static BigRational MINUS_ONE = valueOf(-1);

//private variables 
    private BigInteger numerator;
    private BigInteger denominator;

    //instance class
    public BigRational(BigInteger numerator, BigInteger denominator)
    {
        if(denominator.equals(BigInteger.ZERO))
            throw new ArithmeticException();

        this.numerator = numerator;
        this.denominator = denominator;

        reduce();
    }

    //instance class 
    public BigRational(BigInteger numerator)
    {
        this(numerator, BigInteger.ONE);
    }

    public BigRational()
    {
        this(BigInteger.ZERO);
    }

    //reducing the fraction 
    private void reduce()
    {
        boolean sign = false;
        if(numerator.signum() >= 0 ^ denominator.signum() >= 0)
        {
            sign = true;
        }
        else
        {
            if(numerator.equals(BigInteger.ZERO))
            {
                denominator = BigInteger.ONE;
            }
        }

        numerator = numerator.abs();
        denominator = denominator.abs();

        if(sign)
        {
            numerator = numerator.multiply(BigInteger.valueOf(-1));
        }

        final BigInteger divisor = gcd(numerator.abs(), denominator);
        if(!divisor.equals(BigInteger.ONE))
        {
            numerator = numerator.divide(divisor);
            denominator = denominator.divide(divisor);
        }
    }

   //int method gets the fraction as a int
    public int intValue()
    {
        return numerator.intValue() / denominator.intValue();
    }

   //long method method gets the fraction as a long
    public long longValue()
    {
        return numerator.longValue() / denominator.longValue();
    }

    //float value method gets the fraction as a float
    public float floatValue()
    {
        return numerator.floatValue() / denominator.floatValue();
    }

    //double value method, gets the fraction as a double
    public double doubleValue()
    {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public static BigRational valueOf(long num, long denom)
    {
        return new BigRational(BigInteger.valueOf(num), BigInteger.valueOf(denom));
    }

    public static BigRational valueOf(long num)
    {
        return valueOf(num, 1);
    }

    public BigInteger getNumerator()
    {
        return numerator;
    }

    public BigInteger getDenominator()
    {
        return denominator;
    }

    
    public BigRational add(BigRational n)
    {
        BigInteger num1 = numerator, denom1 = denominator, num2 = n.numerator, denom2 = n.denominator;

        num1 = num1.multiply(denom2);
        num2 = num2.multiply(denom1);
        BigInteger denom = denom1.multiply(denom2);

        return new BigRational(num1.add(num2), denom);
    }

    public BigRational substract(BigRational n)
    {
        return add(new BigRational(n.numerator.multiply(BigInteger.valueOf(-1)), n.denominator));
    }

    public BigRational multiply(BigRational n)
    {
        BigInteger num1 = numerator, denom1 = denominator, num2 = n.numerator, denom2 = n.denominator;

        num1 = num1.multiply(num2);
        denom1 = denom1.multiply(denom2);

        return new BigRational(num1, denom1);
    }

    public BigRational divide(BigRational n)
    {
        return multiply(new BigRational(n.denominator, n.numerator));
    }

    //reciprocal method
    public BigRational reciprocal()
    {
        return ONE.divide(this);
    }

    public boolean isInteger()
    {
        return denominator.equals(BigInteger.ONE);
    }

    public boolean isOne()
    {
        return numerator.equals(denominator);
    }

    public BigRational abs()
    {
        return new BigRational(numerator.abs(), denominator);
    }

    //power method
    public BigRational pow(int n)
    {
        BigRational b = ONE;

        for(int i = 0; i < n; i++)
        {
            b = b.multiply(this);
        }

        return b;
    }

    private BigInteger gcd(BigInteger a, BigInteger b)
    {
        BigInteger r;
        while(!b.equals(BigInteger.ZERO))
        {
            r = a.mod(b);
            a = b;
            b = r;
        }
        return a;
    }
    
    //to big integer method
    public BigInteger toBigInteger(){
    	  if(denominator.equals(BigInteger.ONE)){
    	   return numerator;
    	  }
    	  throw new ArithmeticException("denominator is not one");
    	}
    
    public int toInteger(){
    	  if(denominator.equals(BigInteger.ONE)){
    	   return numerator.intValue();
    	  }
    	  throw new ArithmeticException("denominator is not one");

    	}

    @Override
    public String toString()
    {
        return numerator.toString() + "/" + denominator.toString();
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode(); 
    }

    @Override
    public boolean equals(Object object)
    {
        if(object instanceof BigRational)
        {
            BigRational n = (BigRational) object;
            if(numerator.equals(n.numerator) && denominator.equals(n.denominator))
                return true;
        }
        return false;
    }

    public int compareTo(BigRational o)
    {
        BigInteger a = numerator.multiply(o.denominator);
        BigInteger b = denominator.multiply(o.numerator);

        return a.compareTo(b);
    }
}