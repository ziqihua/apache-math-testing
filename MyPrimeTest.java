import static org.junit.Assert.*;

import org.junit.Test;

public class MyPrimeTest {

	@Test
	public void test2() {
		assertEquals(2, MyPrime.nextPrime(1));
	}

	@Test
	public void testNegativeInput() {
		try {
			MyPrime.nextPrime(-1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// This exception is expected
		}
	}

	@Test
	public void testNextPrimeFrom2() {
		assertEquals(2, MyPrime.nextPrime(2));
	}

	@Test
	public void testNextPrimeFrom3() {
		assertEquals(3, MyPrime.nextPrime(3));
	}

	@Test
	public void testNextPrimeFrom4() {
		assertEquals(5, MyPrime.nextPrime(4));
	}

	@Test
	public void testNextPrimeFromOdd() {
		assertEquals(11, MyPrime.nextPrime(9));
	}

	@Test
	public void testNextPrimeFromDivisibleBy3() {
		assertEquals(7, MyPrime.nextPrime(6));
		assertEquals(13, MyPrime.nextPrime(12));
	}

	@Test
	public void testNextPrimeFromRemainder0() {
		assertEquals(67, MyPrime.nextPrime(62));
	}


	@Test
	public void testNextPrimeFromRemainder1() {
		assertEquals(53, MyPrime.nextPrime(48));
		assertEquals(127, MyPrime.nextPrime(114));
	}

	@Test
	public void testNextPrimeFromRemainder2() {
		assertEquals(11, MyPrime.nextPrime(10));
	}

}
