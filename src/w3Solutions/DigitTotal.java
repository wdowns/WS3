package w3Solutions;

/**
 *  The class contains three static methods to compute the digitTotal
 *  of a number, the average digitTotal of numbers in a range, and the
 *  frequency of a particular digitTotal in a range.
 *  @author: Manfred Kerber
 *  @version: 2015-10-19
 */
public class DigitTotal {

    /**
     *  The method takes in a number and returns its digit total.
     *  
     *  @param n An integer.
     *  @return The digit total of the input
     */
    public static int digitTotal(int n) {
        n = Math.abs(n);
        int result = 0;
        while (n > 0) {
            result += n%10;
            n = n/10;
        }
        return result;
    }

    /**
     *  The method takes in a number and returns the average digit
     *  total in the range between 0 and this number (inclusively).
     *  
     *  @param max An integer.
     *  @return The average digit total of 0, 1, 2, ..., max.
     */
    public static double digitTotalAverage(int max) {
        double average = 0.0;
        for (int i = 0; i <= max; i++){
            average += digitTotal(i);
        }
        return average/(max + 1);
    }

    /**
     *  The method takes in a number and an envisaged digitTotal.  It
     *  returns the proportion of numbers up to the number that have
     *  the envisaged digit total.
     *  
     *  @param max An integer.
     *  @param digitTotal The digitTotal a number should have.
     *  @return The proportion of numbers in 0, 1, 2, ..., max, which
     *  have the given digitTotal.
     */
    public static double digitTotalFrequency(int max, int digitTotal) {
        int counter = 0;
        for (int i = 0; i <= max; i++){
            if (digitTotal(i) == digitTotal) {
                counter++;
            }
        }
        return ((double) counter)/(max + 1);
    }

    /*
     *  Some examples.
     */
    public static void main(String[] args) {
        System.out.println(digitTotal(0));
        System.out.println(digitTotal(7));
        System.out.println(digitTotal(12));
        System.out.println(digitTotal(15));
        System.out.println(digitTotal(213));
        System.out.println(digitTotal(999));
        System.out.println(digitTotal(1111));
        System.out.println(digitTotal(-2));
        System.out.println(digitTotal(327));
        System.out.println(digitTotal(123456789));

        System.out.println("*********************");
        System.out.println(digitTotalAverage(19));
        System.out.println(digitTotalAverage(10));
        System.out.println(digitTotalAverage(327));
        System.out.println(digitTotalAverage(10000));

        System.out.println("*********************");
        System.out.println(digitTotalFrequency(9, 3));
        System.out.println(digitTotalFrequency(99, 3));
        System.out.println(digitTotalFrequency(10000, 3));
        System.out.println(digitTotalFrequency(10000, 20));
        System.out.println(digitTotalFrequency(10000, 100));
    }
}
