package com.lunkes.sicred.pages;

import java.awt.font.NumericShaper;
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

public class BootstrapThemePage {
	
	private WebDriverWait wait;
	private WebDriver driver;

	public BootstrapThemePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);			
	} 
	
	@FindBy(how = How.ID, using = "switch-version-select") 
	private WebElement selectVersion;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/demo/bootstrap_theme_v4/add']") 
	private WebElement addCustomerButton;
	
	@FindBy(how = How.CLASS_NAME, using = "search-button") 
	private WebElement searchButton;
	
	@FindBy(how = How.CLASS_NAME, using = "search-input") 
	private WebElement searchInput;
	
	@FindBy(how = How.CLASS_NAME, using = "select-all-none") 
	private WebElement checkboxAllItens;
	
	@FindBy(how = How.CLASS_NAME, using = "text-danger") 
	private WebElement deleteButton;
	
	@FindBy(how = How.CLASS_NAME, using = "container-fluid") 
	private WebElement container;
	
	@FindBy(how = How.CLASS_NAME, using = "delete-multiple-confirmation-button") 
	private WebElement deleteButtonConfirm;
		
	public void accessPage() {
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}
	
	public boolean changeToVersion(String version) {
		selectVersion.click();
		WebElement option = driver.findElement(By.xpath("//option[contains(text(),'"+ version +"')]"));
		option.click();
		option = driver.findElement(By.xpath("//option[contains(text(),'"+ version +"')]"));
		return option.getAttribute("selected").equals("true");		
	}
	
	public void clickAddButton() {
		addCustomerButton.click();
	}
	
	public void clickSearchButton(){
		searchButton.click();
	}
	
	public void fillOutSearchInput(String text) {
		searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
		waitLoading(1000);
		
		
	}
	
	public void selectAllNone() {
		checkboxAllItens.click();
	}
	
	public void clickDeleteButton() {
		deleteButton.click();
	}
	
	public void timeMiliSeconds(long miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean waitLoading(long timeout) {
		long currentTime = 0;
		long time = 500;
		timeMiliSeconds(time);
		while (true) {
			if (!container.getCssValue("pointer-events").equals("none")) {
				return true;
			}
			if (currentTime >= timeout) {
				new Throwable("Loading did not show");
				return false;
			}else {
				timeMiliSeconds(time);
				currentTime = currentTime + time;				
			}
		}
	}
	
	public boolean waitMessageToConfirmDelete() {
		int numberOfCustomers = driver.findElements(By.className("table-warning")).size();
		String message = new String();
		String className = "alert-delete-multiple";
		
		if(numberOfCustomers == 1) {
			message = "Are you sure that you want to delete this 1 item?";
			className = "alert-delete-multiple-one";
		}else {
			message = "Are you sure that you want to delete those "+ String.valueOf(numberOfCustomers) +" items?";
		}
		
		WebElement popup = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className(className)));
		
		
		return popup.getText().equals(message);	
		
	}
	
	public void clickDeleteButtonConfirm() {
		deleteButtonConfirm.click();
	}
	
	public boolean hasCustomerDeletedMessage(String message) {
		
		WebElement popup = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'"+ message +"')]")));
		
		return popup != null ? true : false;	
		
	}

}
