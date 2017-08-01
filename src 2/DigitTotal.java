/**
 * The digit total of an integer is the integer total you get by adding up the
 * digits. For instance the digit totals of 0, 7, 12, 15, 213, 999, and 1111 are
 * 0, 7, 3, 6, 6, 27, and 4, respectively. Write a classDigitTotal with the
 * following methods:
 * 
 * @author William Downs
 * @date 02/11/15
 */
public class DigitTotal {
	/**
	 * (a) public static int (int n) that returns the digit total of n.
	 * 
	 * @param n
	 * @return
	 */

	public static int digitTotal(int n) {
		int digitTotal = 0;
		int number = Math.abs(n);
		while (number > 0) {
			// Number mod will leave a final digit e.g. 764%10 = 4.
			digitTotal = digitTotal + (number % 10);
			number = number / 10; // Number divided by 10 removes final digit.
		}
		return digitTotal;

	}

	/**
	 * (b) public static double digitTotalAverage(int max) that returns the
	 * average digit total of the numbers 0, 1, 2, ..., max for any positive
	 * integer max. For instance, the digitTotalAverage(9) is computed as
	 * (0+1+...+9)/10.0, that is, 4.5. Likewise digitTotalAverage(19) is
	 * (0+...+9+1...+10)/20.0, which gives 5.0.
	 * 
	 * @param
	 * @param total
	 */

	public static double digitTotalAverage(int max) {

		double total = 0;
		int count = 0;
		while (max >= 0) {
			total += digitTotal(max);
			max = max - 1;
			count++;
		}
		return total / count;
	}

	/**
	 * (c) public static double digitTotalFrequency(int max, int digitTotal)
	 * returns the proportion of numbers which have the given digitTotal
	 * of all the numbers in the range 0, 1,..., max. E.g., the
	 * digitTotalFrequency(9, 3) is 0.1 since only one number out of the first
	 * 10 numbers has a digit total of 3. Likewise digitTotalFrequency(99, 3) is
	 * 0.04 (since out of the first 100 numbers only the numbers 3, 12, 21, and
	 * 30 have a digitTotal of 3).
	 * 
	 */
	public static double digitTotalFrequency(int max, int digitTotal) {
		
		double counter = 0;

		for (int i = 0; i < max; i++) {
			if (digitTotal(i) == digitTotal) {
				counter++;
			}
		}

		return counter / (max + 1);

	}
}