package monefy_pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateExpenseScreenPO extends BasePageObjects {

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
	public CreateExpenseScreenPO(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard1")
	AndroidElement buttonKeyboard1;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard2")
	AndroidElement buttonKeyboard2;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard3")
	AndroidElement buttonKeyboard3;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard4")
	AndroidElement buttonKeyboard4;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard5")
	AndroidElement buttonKeyboard5;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard6")
	AndroidElement buttonKeyboard6;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard7")
	AndroidElement buttonKeyboard7;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard8")
	AndroidElement buttonKeyboard8;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard9")
	AndroidElement buttonKeyboard9;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboard0")
	AndroidElement buttonKeyboard0;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardDot")
	AndroidElement buttonKeyboardDot;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardEquals")
	AndroidElement buttonKeyboardEquals;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardPlus")
	AndroidElement buttonKeyboardPlus;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardMinus")
	AndroidElement buttonKeyboardMinus;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardDivide")
	AndroidElement buttonKeyboardDivide;

	@AndroidFindBy(id = "com.monefy.app.lite:id/buttonKeyboardMultiply")
	AndroidElement buttonKeyboardMultiply;

	@AndroidFindBy(id = "com.monefy.app.lite:id/textViewNote")
	AndroidElement textViewNoteTextbox;

	@AndroidFindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
	AndroidElement chooseCategoryButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Bills\")")
	AndroidElement categoryBillsButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Car\")")
	AndroidElement categoryCarButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Clothes\")")
	AndroidElement categoryClothesButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Communications\")")
	AndroidElement categoryCommunicationsButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Eating out\")")
	AndroidElement categoryEatingoutButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Entertainment\")")
	AndroidElement categoryEntertainmentButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Food\")")
	AndroidElement categoryFoodButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Gifts\")")
	AndroidElement categoryGiftsButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Health\")")
	AndroidElement categoryHealthButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"House\")")
	AndroidElement categoryHouseButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Pets\")")
	AndroidElement categoryPetsButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sports\")")
	AndroidElement categorySportsButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Taxi\")")
	AndroidElement categoryTaxiButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Toiletry\")")
	AndroidElement categoryToiletryButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Transport\")")
	AndroidElement categoryTransportButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Deposits\")")
	AndroidElement categoryDepositsButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Salary\")")
	AndroidElement categorySalaryButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Savings\")")
	AndroidElement categorySavingsButton;
	
	@AndroidFindBy(id="com.monefy.app.lite:id/textViewDate")
	AndroidElement textViewDateButton;

	@AndroidFindBy(id="com.monefy.app.lite:id/mtrl_picker_header_toggle")
	AndroidElement textEditDateButton;

	@AndroidFindBy(id="com.monefy.app.lite:id/confirm_button")
	AndroidElement calendarConfirmButton;

	@AndroidFindBy(className="android.widget.EditText")
	AndroidElement editDateTextBox;
	
	private void clickbuttonKeyboard1() {
		buttonKeyboard1.click();
	}

	private void clickbuttonKeyboard2() {
		buttonKeyboard2.click();
	}

	private void clickbuttonKeyboard3() {
		buttonKeyboard3.click();
	}

	private void clickbuttonKeyboard4() {
		buttonKeyboard4.click();
	}

	private void clickbuttonKeyboard5() {
		buttonKeyboard5.click();
	}

	private void clickbuttonKeyboard6() {
		buttonKeyboard6.click();
	}

	private void clickbuttonKeyboard7() {
		buttonKeyboard7.click();
	}

	private void clickbuttonKeyboard8() {
		buttonKeyboard8.click();
	}

	private void clickbuttonKeyboard9() {
		buttonKeyboard9.click();
	}

	private void clickbuttonKeyboard0() {
		buttonKeyboard0.click();
	}

	private void clickbuttonKeyboardDot() {
		buttonKeyboardDot.click();
	}

	private void clickbuttonKeyboardEquals() {
		buttonKeyboardEquals.click();
	}

	private void clickbuttonKeyboardPlus() {
		buttonKeyboardPlus.click();
	}

	private void clickbuttonKeyboardMinus() {
		buttonKeyboardMinus.click();
	}

	private void clickbuttonKeyboardMultiply() {
		buttonKeyboardMultiply.click();
	}

	private void clickbuttonKeyboardDivide() {
		buttonKeyboardDivide.click();
	}

	public void settextViewNoteTextbox(String noteInput) {
		textViewNoteTextbox.sendKeys(noteInput);
		log.info("Setting Note as " + noteInput);
	}

	public void clickChooseCategoryButton() {
		chooseCategoryButton.click();
		log.info(chooseCategoryButton+" Clicked Successfully");
	}

	private void ClickCategoryBillsButton() {
		categoryBillsButton.click();
	}

	public void setAmount(String expenseAmount) {

		log.info("Setting amount as " + expenseAmount);
		for (int i = 0; i < expenseAmount.length(); i++) {

			switch (expenseAmount.charAt(i)) {
			case '1':
				clickbuttonKeyboard1();
				break;
			case '2':
				clickbuttonKeyboard2();
				break;
			case '3':
				clickbuttonKeyboard3();
				break;
			case '4':
				clickbuttonKeyboard4();
				break;
			case '5':
				clickbuttonKeyboard5();
				break;
			case '6':
				clickbuttonKeyboard6();
				break;
			case '7':
				clickbuttonKeyboard7();
				break;
			case '8':
				clickbuttonKeyboard8();
				break;
			case '9':
				clickbuttonKeyboard9();
				break;
			case '0':
				clickbuttonKeyboard0();
				break;
			case '.':
				clickbuttonKeyboardDot();
			
			}

		}
	}

	public void setExpenseCategory(String categoryName) {
		log.info("Setting expense category as " + categoryName);
		if (categoryName.equalsIgnoreCase("Bills")) {
			categoryBillsButton.click();
		} else if ((categoryName.equalsIgnoreCase("Car"))) {
			categoryCarButton.click();
		} else if ((categoryName.equalsIgnoreCase("Clothes"))) {
			categoryClothesButton.click();
		} else if ((categoryName.equalsIgnoreCase("Communications"))) {
			categoryCommunicationsButton.click();
		} else if ((categoryName.equalsIgnoreCase("Eating out"))) {
			categoryEatingoutButton.click();
		} else if ((categoryName.equalsIgnoreCase("Entertainment"))) {
			categoryEntertainmentButton.click();
		} else if ((categoryName.equalsIgnoreCase("Food"))) {
			categoryFoodButton.click();
		} else if ((categoryName.equalsIgnoreCase("Gifts"))) {
			categoryGiftsButton.click();
		} else if ((categoryName.equalsIgnoreCase("Health"))) {
			categoryHealthButton.click();
		} else if ((categoryName.equalsIgnoreCase("House"))) {
			categoryHouseButton.click();
		} else if ((categoryName.equalsIgnoreCase("Pets"))) {
			categoryPetsButton.click();
		} else if ((categoryName.equalsIgnoreCase("Sports"))) {
			categorySportsButton.click();
		} else if ((categoryName.equalsIgnoreCase("Taxi"))) {
			categoryTaxiButton.click();
		} else if ((categoryName.equalsIgnoreCase("Toiletry"))) {
			categoryToiletryButton.click();
		} else if ((categoryName.equalsIgnoreCase("Transport"))) {
			categoryTransportButton.click();
		}

	}
	
	public void setIncomeCategory(String categoryName) {
		log.info("Setting Income category as " + categoryName);
		if (categoryName.equalsIgnoreCase("Deposits")) {
			categoryDepositsButton.click();
		} else if ((categoryName.equalsIgnoreCase("Salary"))) {
			categorySalaryButton.click();
		} else if ((categoryName.equalsIgnoreCase("Savings"))) {
			categorySavingsButton.click();
		} 

	}
	
	public void clickTextViewDateButton(){
		textViewDateButton.click();
		log.info(textViewDateButton+" Clicked successfully");
	}
	
	public void setDate(String date)
	{
		clickTextViewDateButton();
		textEditDateButton.click();
		editDateTextBox.sendKeys(date);
		calendarConfirmButton.click();
	}

}
