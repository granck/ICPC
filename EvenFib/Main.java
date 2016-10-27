/**
 * EvenFib.java
 *
 * Calculates the sum of all even values in the Fibonacci sequence that are below 4,000,000
 *
 * Garrick Ranck
 * September 16, 2016
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main{

    static Map<Integer, Integer> fibMap = new HashMap<Integer, Integer>();

    public static void main(String[] args){

        int maxFibValue = 4000000;
        makeMap(maxFibValue);

        Scanner input = new Scanner(System.in);


        System.out.println("All keys contained in fibMap");

        fibMap.keySet();
        //loop continues to ask for integers until user provides invalid input or negative value
        //valid input checks map to see if key is found
        //if so it returns sum of values it is composed of (according to mapped value of key)
        for(int value = 0; value >= 0; ){
            System.out.println("Value to find sum for (if not found will return null)");
            System.out.println("Negative values exit loop: ");
            value = input.nextInt();
            if(!fibMap.containsKey(value) && value >= 0){
                System.out.println("null");
            }
            else if(fibMap.containsKey(value)) {
                System.out.println(fibMap.get(value));
            }
        }

    }

    static void makeMap(int maxValue){

        int currentSum = 0;
        int fibFirst = 0;
        int fibSecond = 1;
        int fibNext;

        //fibNext = fibFirst + fibSecond
        //for all fib values between 0 and maxValue
        //check if fibNext = even, then add to currentSum -> map (fibNext, currentSum)
        for(fibNext = fibFirst + fibSecond;  fibNext < 4000000; fibNext = fibFirst + fibSecond){

            System.out.print(fibFirst + " + " + fibSecond + " = " + fibNext + " . ");

            //if even add to sum and map to fibMap
            if(fibNext % 2 == 0){
                currentSum += fibNext;

                //optional. simply to show what values are added to map
                System.out.println("Mapping " + fibNext + " with current sum = " + currentSum
                    + " (includes current fibonacci value)");

                fibMap.put(fibNext, currentSum);
            }
            //optional, can comment out, just to show values that aren't being added
            else{
                System.out.println(fibNext + " not an even value. Not adding to map.");
            }

            //next fibonacci value will require the fibNext value we just discovered and fibSecond
            fibFirst = fibSecond;
            fibSecond = fibNext;
        }
    }

}
