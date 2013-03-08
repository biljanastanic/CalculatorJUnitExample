package calculator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CalculatorTest {

//	@Test
//	public void test() {
//		Calculator c = new Calculator();
//		int r = c.divideInt("-456", "-76");
//		assertEquals(6, r, 0);
//
//	}

//	@Test
//	public void testDivide() {
//		Calculator c = new Calculator();
//		int r = c.divideInt("456", "-76");
//		assertEquals(-6, r, 0);
//	}
	
	@Test
	public void testDivideS() {
		Calculator c = new Calculator();
		String s = c.divideS("500", "76");
		assertEquals("6(44)", s);
	}

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		int r = c.add("456", "0");
		assertEquals(456, r, 0);
	}

	@Test
	public void testMult() {
		Calculator c = new Calculator();
		int r = c.mult("456", "1");
		assertEquals(456, r, 0);
	}
	
	
	
	@Test(expected=DivideByZeroException.class)
	public void testDivideByZero(){
		Calculator c  =  new Calculator();
		c.divide("4", "0");
		
	}
	
	@Test 
	public void testDivideWithPrecision(){
		Calculator c =  new Calculator();
		assertEquals("59.461538461", c.divide("773", "13", 9));
	}
	
	@Test 
	public void testTwoNeg(){
		Calculator c =  new Calculator();
		assertEquals(2, c.twoNeg("-10", "-5"));
	}
	
	@Test 
	public void testAPosBNeg(){
		Calculator c =  new Calculator();
		assertEquals(1, c.aPositiveBNegative("10", "-5"));
	}
	
	@Test 
	public void testBPosANeg(){
		Calculator c =  new Calculator();
		assertEquals(1, c.bPositiveANegative("-10", "5"));
	}
	
	@Test 
	public void testTwoPositive(){
		Calculator c =  new Calculator();
		assertEquals(2, c.twoPositive("100", "5"));
	}

	

	@org.junit.Test
	public void testSub() {
		Calculator calculator = new Calculator();
		double result = calculator.sub("10", "4");
		assertEquals(6, result, 0);

	}

	@Test
	public void testEncodeToString() {
		Calculator test = new Calculator();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		assertEquals("2.5", test.encodeToString(list));

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(59);
		list2.add(4);
		list2.add(6);
		list2.add(1);
		list2.add(5);
		list2.add(4);
		assertEquals("59.46154", test.encodeToString(list2));
	}

	@Test
	public void testCountSubstractionIrrational() {
		Calculator c = new Calculator();
		List<Integer> expected = Arrays.asList(59, 4, 6, 1, 5, 3);
		assertEquals(expected, c.countSubstraction(773, 13,5));
	}


}
