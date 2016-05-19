package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import salestaxcalc.STCalculator;

public class BillProcessingTest2 {

	STCalculator caseTwo = new STCalculator();
	private static final String INPUT_1 = "1 imported box of chocolates at 10.00";
	private static final String INPUT_2 = "1 imported bottle of perfume at 47.50";
	private static final String INPUT_3 = "exit";
	private static final String OUTPUT_1 = "1 imported box of chocolates: 10.50";
	private static final String OUTPUT_2 = "1 imported bottle of perfume: 54.62";
	private static final String OUTPUT_3 = "Sales Taxes: 4.75";
	private static final String OUTPUT_4 = "Total: 65.12";

	@Test
	public void test1() {
		assertEquals(OUTPUT_1, caseTwo.billProcessing(INPUT_1));
	}
	@Test
	public void test2() {
		assertEquals(OUTPUT_2, caseTwo.billProcessing(INPUT_2));
	}@Test
	public void test3() {
		assertEquals(OUTPUT_3+"\n"+OUTPUT_4, caseTwo.billProcessing(INPUT_3));
	}
}