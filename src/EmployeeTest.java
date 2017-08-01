import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author William Downs
 * @date 05/11/15
 */

public class EmployeeTest {

	private double[] salaryWill = { 1000, 1000, 1000, 0, 0, 0, 0, 0, 0, 0, 0,
			1500 };
	private double[] salaryMarion = { 1100, 1100, 1100, 1100, 1100, 1100, 1100,
			1110, 1100, 1100, 1100, 1100 };
	private double precision = 0.000001;
	private Employee will;
	
	@Before
	public void setUp() {
		will = new Employee("Will Downs", "CS Bham", salaryWill);
		new Employee("Marion Downs", "CS Bham", salaryMarion);
		new AllEmployees();
	}

	@Test
	public void test1() {
		assertEquals("Will Downs", will.getName());
		assertEquals("CS Bham", will.getAddress());

		double[] expectedSalariesJohn = { 1000, 1000, 1000, 0, 0, 0, 0, 0, 0, 0,
				0, 1500 };
		assertArrayEquals(expectedSalariesJohn, will.getSalaries(), precision);
	}
}
