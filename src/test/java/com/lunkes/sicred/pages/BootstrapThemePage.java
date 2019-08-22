package com.lunkes.sicred.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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

}
