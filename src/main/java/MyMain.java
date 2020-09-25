import java.util.Scanner;
//import java.lang.reflect.Array;
//import java.util.Arrays;

public class MyMain {

    // Rolls a single die
    // Returns a random integer between 1 and 6
    public static int rollDie() {
        int DiceOutput = (int)((Math.random() * 6) + 1);
        return DiceOutput;
    }

    // Rolls two dice n times
    // This method returns an int array of size 11, where each element is
    // the number of times a certain sum of two dice was rolled
    public static int[] sumOfTwoDice(int n) {
        int[] DieComboList = new int[11];
        int sum;
        for (int i = 0; i < n; i++) {
            int DieRoll1 = rollDie();
            int DieRoll2 = rollDie();
            sum = DieRoll1 + DieRoll2;
            //System.out.println(sum);
            //System.out.println(i);
            DieComboList[(DieRoll1+DieRoll2) - 2]++;
            //DieComboList[sum-2]++;
        }   
        //Arrays.toString(DieComboList);
        return DieComboList;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many pairs of dice would you like to roll?: ");
        int n = scan.nextInt();
        int[] sums = sumOfTwoDice(n);

        for(int i = 0; i < 11; i++) {
            System.out.println("% of rolls where sum == " + (i + 2) + ": " + (sums[i] / (double) n) * 100);
        }
        scan.close();
    }
}
