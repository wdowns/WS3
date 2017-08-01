import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author William Downs
 * @date 05/11/15
 */

public class DigitTotalTest {

	private double precision = 0.000001;

	@Test
	public void test1() {
		int expected = 1;
		assertEquals(expected, DigitTotal.digitTotal(1));
	}

	@Test
	public void test2() {
		int expected = 9;
		assertEquals(expected, DigitTotal.digitTotal(333));
	}

	@Test
	public void test3() {
		int expected = 3;
		assertEquals(expected, DigitTotal.digitTotal(-3));
	}

	@Test
	public void test5() {
		double expected = 5.0;
		assertEquals(expected, DigitTotal.digitTotalAverage(19), precision);
	}

	@Test
	public void test6() {
		double expected = 4.0;
		assertEquals(expected, DigitTotal.digitTotalAverage(8), precision);
	}

	@Test
	public void test9() {
		double expected = 0.04;
		assertEquals(expected, DigitTotal.digitTotalFrequency(99, 3), precision);
	}

}

