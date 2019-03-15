/*This is a Integer class.
 The methods are used to determine if the integer is prime, even, and odd.
 */ 
public class Exercise1 {
    public static void main(String[] args) { 
        
      MyInteger n1 = new MyInteger(5); 

     
      System.out.println("n1 is even? " + n1.isEven()); 
      System.out.println("n1 is prime? " + n1.isPrime()); 
      System.out.println("15 is prime? " + MyInteger.isPrime(15));

      
      char[] chars = {'3', '5', '3', '9'}; 
      System.out.println(MyInteger.parseInt(chars)); 
      String s = "3539"; 
      System.out.println(MyInteger.parseInt(s)); 
      MyInteger n2 = new MyInteger(24); 
      System.out.println("n2 is odd? " + n2.isOdd()); 
      System.out.println("45 is odd? " + MyInteger.isOdd(45)); 
      System.out.println("n1 is equal to n2? " + n1.equals(n2)); 
      System.out.println("n1 is equal to 5? " + n1.equals(5)); }
  }


class MyInteger {

   
    private int value;

    
    public MyInteger(int value) {
        this.value  = value;
    }

    public int getValue() {
        return value;
    }

   
    public boolean isEven() {
        return (value % 2) == 0;
    }

    
    public boolean isOdd() {
        return (value % 2) == 1;
    }

    
    public boolean isPrime() {

        if (value == 1 || value == 2) {
            return true;
        }
        else {
            for (int i = 2; i < value; i++) {
                if (i % value == 0) return false;
            }
        }
        return true;
    }

     
    public static boolean isEven(int newInt) {
        return (newInt % 2) == 0;
    }

    public static boolean isOdd(int newInt) {
        return (newInt % 2) == 1;
    }

    public static boolean isPrime(int newInt) {
        if (newInt == 1 || newInt == 2) {
            return true;
        }
        else {
            for (int i = 2; i < newInt; i++) {
                if (i % newInt == 0) return false;
            }
        }
        return true;
    }    

    public static boolean isEven(MyInteger newInt) {
        return newInt.isEven();
    }

    public static boolean isOdd(MyInteger newInt) {
        return newInt.isOdd();
    }

    public static boolean isPrime(MyInteger newInt) {
        return newInt.isPrime();
    }

    public boolean equals(int testInt) {
        if (testInt == value) 
            return true;
        return false;
    }

    public boolean equals(MyInteger newInt) {
        if (newInt.value == this.value) 
            return true;
        return false;
    }

    public static int parseInt(char[] values) {
        int sum = 0;
        for (char i : values) {
            sum += Character.getNumericValue(i);
        }
        return sum;
    }

    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }
}


