
import java.math.BigInteger;

public class TestClass {

    public static void main(String[] args) {
     //creating numerator and denomerator
    BigInteger numerator = new BigInteger("4");
    BigInteger denomerator = new BigInteger("2");

    BigRational test = new BigRational(numerator, denomerator);
    
    // pow method test
    System.out.println(test.pow(4));

    // reciprocal method
    System.out.println(test.reciprocal());

    // toBigInteger method
    System.out.println(test.toBigInteger());

    // toInteger method
    System.out.println(test.toInteger());
     
       
    }

}

