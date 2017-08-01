/**
 * @author William Downs
 * @date 05/11/15
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class StarRatingTest {

	@Test
	public void test1() {
		double rating = 2.0;
		String expected = "crap";

		assertEquals(expected, StarRating.interpret(rating));
	}

	@Test
	public void test2() {

		double[] rating = { 1.5, 3.5, 2.0, 2.5, 3.0, };
		String expected = "crap";

		for (double r : rating) {
			assertEquals(expected, StarRating.interpret(r));
		}
	}

	@Test
	public void test3() {

		double rating = 3.5;
		double rating1 = 4.0;
		double rating2 = 4.5;
		String expected = "crap";
		String expected1 = "OK";
		String expected2 = "excellent";

		assertEquals(expected, StarRating.interpret(rating));
		assertEquals(expected1, StarRating.interpret(rating1));
		assertEquals(expected2, StarRating.interpret(rating2));

	}

	@Test
	public void test4() {
		double[] rating = { 4.6, 4.66667, 4.99999 };
		String expected = "excellent";
		for (double r : rating) {
			assertEquals(expected, StarRating.interpretRange(r));
		}
	}

	@Test
	public void test5() {
		double rating = -0.05;
		String expected = "not rated";

		assertEquals(expected, StarRating.interpretRange(rating));

	}

}
