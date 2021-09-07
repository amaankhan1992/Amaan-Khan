package monefy_tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import monefy_pageobjects.CreateExpenseScreenPO;
import monefy_pageobjects.ExpenseHomeScreenPO;
import monefy_utils.TestDataProvider;

public class TestCases extends Testbase {

	
	ExpenseHomeScreenPO expenseHomeScreenPO;
	CreateExpenseScreenPO createExpenseScreenPO;
	
	@BeforeMethod
	public void openApp() {
		expenseHomeScreenPO = new ExpenseHomeScreenPO(driver);
		createExpenseScreenPO = new CreateExpenseScreenPO(driver);
		
	}
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		
	}
	
	@Test (dataProvider="getDataFromExcel", dataProviderClass=TestDataProvider.class)
	public void createExpense(String expenseAmount, String noteInput, String categoryName)
	{
		expenseHomeScreenPO.tapExpenseButtonTile();
		createExpenseScreenPO.setAmount(expenseAmount);
		createExpenseScreenPO.settextViewNoteTextbox(noteInput);
		createExpenseScreenPO.clickChooseCategoryButton();
		createExpenseScreenPO.setExpenseCategory(categoryName);
		Assert.assertTrue(expenseHomeScreenPO.getSuccessMessage().contains(expenseAmount));
		Assert.assertTrue(expenseHomeScreenPO.getSuccessMessage().contains(categoryName));
	}
	
	
	@Test(dataProvider="getDataFromExcel", dataProviderClass=TestDataProvider.class)
	public void createIncome(String incomeAmount, String noteInput, String categoryName)
	{
		expenseHomeScreenPO.tapIncomeButtonTile();
		createExpenseScreenPO.setAmount(incomeAmount);
		createExpenseScreenPO.settextViewNoteTextbox(noteInput);
		createExpenseScreenPO.clickChooseCategoryButton();
		createExpenseScreenPO.setIncomeCategory(categoryName);
		Assert.assertTrue(expenseHomeScreenPO.getSuccessMessage().contains(incomeAmount));
		Assert.assertTrue(expenseHomeScreenPO.getSuccessMessage().contains(categoryName));
	}
	
	
	
	
	
	

}
