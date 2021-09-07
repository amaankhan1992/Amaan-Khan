package monefy_pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExpenseHomeScreenPO extends BasePageObjects {

	private static Logger log = LogManager.getLogger(ExpenseHomeScreenPO.class);
	BasePageObjects basePageObjects;

	/**
	 * A base constructor that sets the page's driver
	 * <p>
	 * The page structure is being used within this test in order to separate
	 * the page actions from the tests.
	 * <p>
	 * Please use the AppiumFieldDecorator class within the page factory. This
	 * way annotations like @AndroidFindBy within the page objects.
	 *
	 * @param driver
	 *            the appium driver created in the beforesuite method.
	 */
	public ExpenseHomeScreenPO(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.monefy.app.lite:id/expense_button_title")
	AndroidElement expenseButtonTile;

	@AndroidFindBy(id = "com.monefy.app.lite:id/income_button_title")
	AndroidElement incomeButtonTile;

	@AndroidFindBy(id = "com.monefy.app.lite:id/snackbar_text")
	AndroidElement successMessage;

	/**
	 * This method will click on expense tile.
	 */
	public void tapExpenseButtonTile() {
		expenseButtonTile.click();
		log.info(expenseButtonTile + "Clicked successfully");
	}
	
	/**
	 * This method will click on expense tile.
	 */	
	public void tapIncomeButtonTile() {
		incomeButtonTile.click();
		log.info(incomeButtonTile + "Clicked successfully");
	}

	public String getSuccessMessage() {
		String msg = successMessage.getText();
		String msgWithoutComma = msg.replace(",", "");
		log.info("Success Message is " + msgWithoutComma);
		return msgWithoutComma;
	}

}
