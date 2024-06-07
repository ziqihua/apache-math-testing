import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.junit.Test;
import static org.junit.Assert.*;

public class MySorterTest {

	@Test
	public void testSortInPlaceIncreasing() {
		double[] x = {5, 3, 4};
		double[] y = {7, 8, 9};
		MySorter.sortInPlace(x, MySorter.OrderDirection.INCREASING, y);
		assertArrayEquals(new double[]{3, 4, 5}, x, 0);
		assertArrayEquals(new double[]{8, 9, 7}, y, 0);
	}

	@Test
	public void testSortInPlaceDecreasing() {
		double[] x = {5, 3, 4};
		double[] y = {7, 8, 9};
		MySorter.sortInPlace(x, MySorter.OrderDirection.DECREASING, y);
		assertArrayEquals(new double[]{5, 4, 3}, x, 0);
		assertArrayEquals(new double[]{7, 9, 8}, y, 0);
	}

	@Test(expected = NullArgumentException.class)
	public void testBothNullInputs() {
		MySorter.sortInPlace(null, MySorter.OrderDirection.DECREASING, (double[]) null);
	}

	@Test(expected = NullArgumentException.class)
	public void testNullYArray() {
		MySorter.sortInPlace(new double[]{1, 2, 3}, MySorter.OrderDirection.DECREASING, (double[]) null);
	}

	@Test(expected = DimensionMismatchException.class)
	public void testDimensionMismatch() {
		double[] x = {5, 3, 4};
		double[] y = {7, 8};
		MySorter.sortInPlace(x, MySorter.OrderDirection.DECREASING, y);
	}

	@Test
	public void testEmptyArrays() {
		double[] x = {};
		double[] y = {};
		MySorter.sortInPlace(x, MySorter.OrderDirection.DECREASING, y);
		assertArrayEquals(new double[]{}, x, 0);
		assertArrayEquals(new double[]{}, y, 0);
	}
}
