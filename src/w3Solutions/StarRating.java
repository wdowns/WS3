package w3Solutions;

/**
 *  The class contains two static methods to translate a numerical
 *  rating into a a verbal rating.
 *  @author: Manfred Kerber
 *  @version: 2015-10-19
 */
public class StarRating {

    /**
     *  The method takes in a rating and returns Strings with a verbal 
     *  description of the rating if the ratings are exactly matched
     *  else it returns "not rated".
     *  
     *  @param rating The rating as a value of 1.0, 1.5, ..., 5.0
     *  @return A translation into English. "not rated" if it is none
     *  of the value above.
     */
    public static String interpret(double rating) {
        if (rating == 1.0 || rating == 1.5 || rating == 2 ||
            rating == 2.5 || rating == 3.0 || rating == 3.5) {
            return "crap";
        } else if (rating == 4.0) {
            return "OK";
        } else if (rating == 4.5) {
            return "excellent";
        } else if (rating == 5.0) {
            return "[has only one review]";
        } else {
            return "not rated";
        }
    }

    /**
     *  The method takes in a rating and returns Strings with a verbal 
     *  description of the rating if the ratings are in a particular interval
     *  else it returns "not rated".
     *  
     *  @param rating The rating as a value above 1.0.
     *  @return A translation into English. "not rated" if less than 1.0
     */
    public static String interpretRange(double rating) {
        if (0.0 <= rating && rating < 4.0) {
            return "crap";
        } else if (4.0 <= rating && rating < 4.5) {
            return "OK";
        } else if (4.5 <= rating && rating < 5.0) {
            return "excellent";
        } else if (rating >= 5.0) {
            return "[has only one review]";
        } else {
            return "not rated";
        }
    }

    /*
     *   Some few tests.
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
