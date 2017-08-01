/**
 * Translate a StarRating cartoon into a program, implemented as a class
 * public class StarRating with a method public static String interpret
 * (double rating).
 * @author William Downs
 * @version 01/11/15
 */

/**
 * (a) For any numeric rating given in the figure (1.0, 1.5, ..., 5.0) interpret
 * should return a textual interpretation as in the cartoon, e.g. "OK", and
 * otherwise "not rated".
 */

public class StarRating {
	/**
	 * @param rating The rating as a value of 1.0, 1.5, ..., 5.0
	 * @return A translation into English. "not rated" if it is none
     *  of the value above.
	 */

	public static String interpret(double rating) {

		if (rating == 0.0) {
			return "not rated";
		} else if (rating <= 3.5) {
			return "crap";
		} else if (rating == 4.0) {
			return "OK";
		} else if (rating == 4.5) {
			return "excellent";
		} else if (rating == 5.0) {
			return ("[has only one review]");
		} else
			return "not rated";
	}

	/**
	 * (b) Add a method public static String interpretRange(double rating) that
	 * interprets any rating 0< x <5 (which could be interpreted as the rating
	 * averaged over several individual ratings), and otherwise returns
	 * "not rated". A "crap" rating starts at 0.0 and may extend up to, but
	 * excluding, 4.0; "OK" should start from 4.0, "excellent" from 4.5, and
	 * "[has only one review]" from 5.0.
	 * 
	 *  @param rating The rating as a value above 1.0.
     *  @return A translation into English. "not rated" if less than 1.0
	 */

	public static String interpretRange(double rating) {

		if (rating < 0.0) {
			return "not rated";
		} else if (rating < 4.0) {
			return "crap";
		} else if (rating < 4.5) {
			return "OK";
		} else if (rating < 5.0) {
			return "excellent";
		} else if (rating > 5.0) {
			return "[has only one review]";
		} else
			return "[has only one review]";
	}
	 /*
     *   Some few tests. (taken from Manfred's solutions)
     */
    public static void main(String[] args) {
        System.out.println(interpret(1.0));
        System.out.println(interpret(2.0));
        System.out.println(interpret(3.0));
        System.out.println(interpret(4.0));
        System.out.println(interpret(4.5));
        System.out.println(interpret(5.0));
        System.out.println(interpret(2.1));

        System.out.println();
        System.out.println(interpretRange(1.0));
        System.out.println(interpretRange(2.0));
        System.out.println(interpretRange(3.0));
        System.out.println(interpretRange(4.0));
        System.out.println(interpretRange(4.5));
        System.out.println(interpretRange(5.0));
        System.out.println(interpretRange(2.1));
    }

}
