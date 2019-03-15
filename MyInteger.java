//the purpose of this code is to roll four dices 
public class Num4 {
    public static void main(String[] args) {
        //test object
        TestNum test  = new TestNum();
        //calling rolling dice
        test.rollingDice();
       
        
    }
}
class TestNum{
    public void rollingDice(){
        
        //for loop to roll the dice 12960
        for (int i = 1; i <= 12960; i++) {
            int rand1 = (int)(Math.random() * 6 + 1);
            int rand2 = (int)(Math.random() * 6 + 1);
            int rand3 = (int)(Math.random() * 6 + 1);
            int rand4 = (int)(Math.random() * 6 + 1);
            int sum = rand1 + rand2 + rand3 + rand4;
       
            //prints the sum 
            System.out.println(sum);
        }
    }
}