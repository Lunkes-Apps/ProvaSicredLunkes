package com.lunkes.sicred.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {
	public WebDriverWait wait;
	private WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	@FindBy(how = How.ID, using = "field-customerName")
	private WebElement nameField;

	@FindBy(how = How.ID, using = "field-contactLastName")
	private WebElement lastNameField;

	@FindBy(how = How.ID, using = "field-contactFirstName")
	private WebElement firstNameField;

	@FindBy(how = How.ID, using = "field-phone")
	private WebElement phoneField;

	@FindBy(how = How.ID, using = "field-addressLine1")
	private WebElement addressLine1Field;

	@FindBy(how = How.ID, using = "field-addressLine2")
	private WebElement addressLine2Field;

	@FindBy(how = How.ID, using = "field-city")
	private WebElement cityField;

	@FindBy(how = How.ID, using = "field-state")
	private WebElement stateField;

	@FindBy(how = How.ID, using = "field-postalCode")
	private WebElement postalCodeField;

	@FindBy(how = How.ID, using = "field-country")
	private WebElement countryField;

	@FindBy(how = How.XPATH, using = "//*[@id='field_salesRepEmployeeNumber_chosen']/a")
	private WebElement employeerSelect;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='chosen-search']/input")
	private WebElement employeerFildText;

	@FindBy(how = How.ID, using = "field-creditLimit")
	private WebElement creditLimitField;

	@FindBy(how = How.ID, using = "form-button-save")
	private WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//a[@href='/demo/bootstrap_theme_v4/']")
	private WebElement goBackToList;

	public void fillOutInfo(List<String> info) {
		nameField.sendKeys(info.get(0));
		lastNameField.sendKeys(info.get(1));
		firstNameField.sendKeys(info.get(2));
		phoneField.sendKeys(info.get(3));
		addressLine1Field.sendKeys(info.get(4));
		addressLine2Field.sendKeys(info.get(5));
		cityField.sendKeys(info.get(6));
		stateField.sendKeys(info.get(7));
		postalCodeField.sendKeys(info.get(8));
		countryField.sendKeys(info.get(9));
		selectEmployeer(info.get(10));
		creditLimitField.sendKeys(info.get(11));;

	}
	
	public void selectEmployeer(String employeer) {
		employeerSelect.click();
		employeerFildText.sendKeys(employeer);
		employeerFildText.sendKeys(Keys.ENTER);		
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public boolean waitSuccessfullyStoredDataMessage() {
		WebElement message = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Your data has been successfully stored into the database.')]")));
		
		return message != null ? true : false;
	}

}
