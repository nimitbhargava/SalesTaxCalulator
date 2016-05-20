package salestaxcalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Bill {

	private String[] nonBST = { "book", "food", "medical" };
	private String[] addedNonBST = { "chocolate", "chocolates", "pills" };

	private static double billTotal;
	private static double salesTaxTotal;

	private static final String PRICE_AT = " at ";
	private static final double BASIC_SALES_TAX = 0.10; // defined for basic
														// sales tax
	private static final double IMPORT_DUTY = 0.05; // defined for import duty
	private static final String EXIT = "exit";
	private static final String IMPORTED = "imported";

	private static final String PRINT_SALES_TAXES = "Sales Taxes: ";
	private static final String PRINT_SALES_TOTAL = "Total: ";

	public double getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(double billTotal) {
		Bill.billTotal = billTotal;
	}

	public double getSalesTaxTotal() {
		return salesTaxTotal;
	}

	public void setSalesTaxTotal(double salesTaxTotal) {
		Bill.salesTaxTotal = salesTaxTotal;
	}

	public boolean isImported(String item) {
		String[] array = item.split("\\s");
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(IMPORTED))
				return true;
		}
		return false;
	}

	public boolean isBSTApplicable(String item) {
		String[] itemList = item.split("\\s");
		for (int i = 0; i < itemList.length; i++) {
			for (int j = 0; j < nonBST.length; j++) {
				if (itemList[i].equals(nonBST[j]))
					return false;
			}
			for (int k = 0; k < addedNonBST.length; k++) {
				if (itemList[i].equals(addedNonBST[k]))
					return false;
			}
		}
		return true;
	}

	public boolean isEnd(String item) {
		return (item.equals(EXIT) ? true : false);
	}

	public double getPrice(String item) {
		String[] itemList = item.split("\\s");
		return Double.parseDouble(itemList[itemList.length - 1]);
	}

	public double getItemTotal(double importedValue, double salesTax,
			double price) {
		return price + importedValue + salesTax;
	}

	public String getItemStatement(double itemTotal, String item) {
		String[] itemList = item.split(PRICE_AT);
		itemList[itemList.length - 1] = decimalFormat(itemTotal).toString();
		String itemStatement = itemList[0].trim() + ": " + itemList[1];
		return itemStatement.trim();
	}

	public static String decimalFormat(double number) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(number);
	}

	public void startBill() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Bill bill = new Bill();
		while (true) {
			String item = null;
			try {
				item = br.readLine().trim();
			} catch (IOException e) {
				System.out.println("Incorrect input.");
				e.printStackTrace();
			}
			System.out.println(bill.billProcessing(item));
			bill.setBillTotal(0);
			bill.setSalesTaxTotal(0);

		}
	}

	public String billProcessing(String item) {
		Bill itemList = new Bill();
		if (itemList.isEnd(item)) {
			String salesTaxes = decimalFormat(itemList.getSalesTaxTotal());
			String salesTotal = decimalFormat(itemList.getBillTotal());
						
			itemList.setSalesTaxTotal(0);
			itemList.setBillTotal(0);
			
			return (PRINT_SALES_TAXES + salesTaxes)
					+ "\n"
					+ (PRINT_SALES_TOTAL + salesTotal);
		}
		double price = itemList.getPrice(item);
		double importedValue = itemList.isImported(item) ? price * IMPORT_DUTY
				: 0;
		double salesTax = itemList.isBSTApplicable(item) ? price
				* BASIC_SALES_TAX : 0;
		double itemTotal = itemList
				.getItemTotal(importedValue, salesTax, price);
		itemList.setSalesTaxTotal(itemList.getSalesTaxTotal() + salesTax);
		itemList.setBillTotal(itemList.getBillTotal() + itemTotal);
		return (itemList.getItemStatement(itemTotal, item));

	}
}
