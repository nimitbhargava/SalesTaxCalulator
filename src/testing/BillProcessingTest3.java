package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import salestaxcalc.STCalculator;

public class BillProcessingTest3 {

	STCalculator caseThree = new STCalculator();
	private static final String INPUT_1 = "1 imported bottle of perfume at 27.99";
	private static final String INPUT_2 = "1 bottle of perfume at 18.99";
	private static final String INPUT_3 = "1 packet of headache pills at 9.75";
	private static final String INPUT_4 = "1 box of imported chocolates at 11.25";
	private static final String INPUT_5 = "exit";
	private static final String OUTPUT_1 = "1 imported bottle of perfume: 32.19";
	private static final String OUTPUT_2 = "1 bottle of perfume: 20.89";
	private static final String OUTPUT_3 = "1 packet of headache pills: 9.75";
	private static final String OUTPUT_4 = "1 box of imported chocolates: 11.81";
	private static final String OUTPUT_5 = "Sales Taxes: 4.70";
	private static final String OUTPUT_6 = "Total: 74.64";
	
	@Test
	public void test1() {
		assertEquals(OUTPUT_1, caseThree.billProcessing(INPUT_1));
	}
	@Test
	public void test2() {
		assertEquals(OUTPUT_2, caseThree.billProcessing(INPUT_2));
	}
	@Test
	public void test3() {
		assertEquals(OUTPUT_3, caseThree.billProcessing(INPUT_3));
	}
	@Test
	public void test4() {
		assertEquals(OUTPUT_4, caseThree.billProcessing(INPUT_4));
	}
	@Test
	public void test5() {
		assertEquals(OUTPUT_5+"\n"+OUTPUT_6, caseThree.billProcessing(INPUT_5));
	}
}
