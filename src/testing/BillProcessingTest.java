package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import salestaxcalc.STCalculator;

public class BillProcessingTest {

	STCalculator caseOne = new STCalculator();
	private static final String INPUT_1 = "1 book at 12.49";
	private static final String INPUT_2 = "1 music CD at 14.99";
	private static final String INPUT_3 = "1 chocolate bar at 0.85";
	private static final String INPUT_4 = "exit";
	private static final String OUTPUT_1 = "1 book: 12.49";
	private static final String OUTPUT_2 = "1 music CD: 16.49";
	private static final String OUTPUT_3 = "1 chocolate bar: 0.85";
	private static final String OUTPUT_4 = "Sales Taxes: 1.50";
	private static final String OUTPUT_5 = "Total: 29.83";

	@Before
	public void setUp() throws Exception {
		caseOne.setBillTotal(0);
		caseOne.setSalesTaxTotal(0);
	}
//	
//	@After
//	public void tearDown() throws Exception {
//		caseOne.setBillTotal(0);
//		caseOne.setBillTotal(0);
//	}
//	
	@Test
	public void test1() {
		assertEquals(OUTPUT_1, caseOne.billProcessing(INPUT_1));
	}
	@Test
	public void test2() {
		assertEquals(OUTPUT_2, caseOne.billProcessing(INPUT_2));
	}
	@Test
	public void test3() {
		assertEquals(OUTPUT_3, caseOne.billProcessing(INPUT_3));
	}
	@Test
	public void test4() {
		assertEquals(OUTPUT_4+"\n"+OUTPUT_5, caseOne.billProcessing(INPUT_4));
	}
}
