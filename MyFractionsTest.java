import static org.junit.Assert.*;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

public class MyFractionsTest {

	@Test(expected = NullArgumentException.class)
	public void testF1NullF2Null() {
		MyFractions.addSub(null, null, true);
	}

	@Test(expected = NullArgumentException.class)
	public void testF1Null() {
		MyFractions.addSub(null, new Fraction(1, 2), true);
	}

	@Test(expected = NullArgumentException.class)
	public void testF2Null() {
		MyFractions.addSub(new Fraction(1, 2), null, true);
	}

	@Test
	public void testF1ZeroNumeratorAdd() {
		Fraction f1 = new Fraction(0, 1);
		Fraction f2 = new Fraction(1, 2);
		Fraction result = MyFractions.addSub(f1, f2, true);
		assertEquals(f2, result);
	}

	@Test
	public void testF1ZeroNumeratorSubtract() {
		Fraction f1 = new Fraction(0, 1);
		Fraction f2 = new Fraction(1, 2);
		Fraction result = MyFractions.addSub(f1, f2, false);
		assertEquals(f2.negate(), result);
	}

	@Test
	public void testF2ZeroNumerator() {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(0, 1);
		Fraction result = MyFractions.addSub(f1, f2, true);
		assertEquals(f1, result);
	}

	@Test
	public void testCommonDenominatorAdd() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(2, 3);
		Fraction result = MyFractions.addSub(f1, f2, true);
		assertEquals(new Fraction(1, 1), result);
	}

	@Test
	public void testCommonDenominatorSubtract() {
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(2, 3);
		Fraction result = MyFractions.addSub(f1, f2, false);
		assertEquals(new Fraction(-1, 3), result);
	}

	@Test
	public void testDifferentDenominatorAdd() {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		Fraction result = MyFractions.addSub(f1, f2, true);
		assertEquals(new Fraction(5, 6), result);
	}

	@Test
	public void testDifferentDenominatorSubtract() {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 3);
		Fraction result = MyFractions.addSub(f1, f2, false);
		assertEquals(new Fraction(1, 6), result);
	}

	@Test(expected = MathArithmeticException.class)
	public void testLargeValuesAdd() {
		Fraction f1 = new Fraction(Integer.MAX_VALUE, 1);
		Fraction f2 = new Fraction(Integer.MAX_VALUE, 1);
		MyFractions.addSub(f1, f2, true);
	}


	@Test
	public void testLargeValuesSubtract() {
		Fraction f1 = new Fraction(Integer.MAX_VALUE, 1);
		Fraction f2 = new Fraction(Integer.MAX_VALUE, 1);
		Fraction result = MyFractions.addSub(f1, f2, false);
		assertEquals(new Fraction(0, 1), result);
	}

	@Test(expected = MathArithmeticException.class)
	public void testEdgeCasesAdd() {
		Fraction f1 = new Fraction(1, Integer.MAX_VALUE);
		Fraction f2 = new Fraction(1, Integer.MAX_VALUE - 1);
		MyFractions.addSub(f1, f2, true);
	}


	@Test(expected = MathArithmeticException.class)
	public void testEdgeCasesSubtract() {
		Fraction f1 = new Fraction(1, Integer.MAX_VALUE);
		Fraction f2 = new Fraction(1, Integer.MAX_VALUE - 1);
		MyFractions.addSub(f1, f2, false);
	}


	@Test(expected = MathArithmeticException.class)
	public void testArithmeticException() {
		Fraction f1 = new Fraction(Integer.MAX_VALUE, 1);
		Fraction f2 = new Fraction(1, Integer.MAX_VALUE);
		MyFractions.addSub(f1, f2, true);
	}
}
