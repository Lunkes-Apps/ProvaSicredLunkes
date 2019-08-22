package com.lunkes.sicred.steps;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lunkes.sicred.pages.AddCustomerPage;
import com.lunkes.sicred.pages.BootstrapThemePage;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSicredSteps {
		
	private WebDriver driver;
    private BootstrapThemePage bootstrapThemePage;
    private AddCustomerPage addCustomerPage;
	
	@Before (order = 0)
	public void setUp(){ 
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
						
	}
	
	@Given("^I have accessed the Bootstrap Theme page$")
	public void iHaveAccessedTheBootstrapThemePage() throws Throwable {
	    bootstrapThemePage = new BootstrapThemePage(driver);
	    bootstrapThemePage.accessPage();
	}

	@When("^I change the bootstrap version to \"(.*)\"$")
	public void iChangeTheBootstrapVersionTo(String version) throws Throwable {
	    boolean result = bootstrapThemePage.changeToVersion(version);
	    assertTrue("It did not change to version " + version, result);
	}

	@When("^I access the Add Page$")
	public void iAccessTheAddPage() throws Throwable {
	    bootstrapThemePage.clickAddButton();
	    
	}

	@When("^I fill out the custormer's information$")
	public void iFillOutTheCustormerSInformation(DataTable informations) throws Throwable {
		 List<String> info = informations.asList(String.class);
		 addCustomerPage = new AddCustomerPage(driver);
		 addCustomerPage.fillOutInfo(info);
		 
	}

	@When("^I click in save button$")
	public void iClickInSaveButton() throws Throwable {
	    addCustomerPage.clickSaveButton();
	}

	@Then("^Will show a menssage \"(.*)\"$")
	public void willShowAMenssage(String arg1) throws Throwable {
	    assertTrue("The message was not show", addCustomerPage.waitSuccessfullyStoredDataMessage());
	}
	
	@When("^I click in Go back to list$")
	public void iClickInGoBackToList() throws Throwable {
	  addCustomerPage.clickGoBackToList();
	}

	@When("^I search the name \"(.*)\"$")
	public void iSearchTheName(String text) throws Throwable {
	   bootstrapThemePage.clickSearchButton();
	   bootstrapThemePage.fillOutSearchInput(text);
	}

	@When("^I select all itens$")
	public void iSelectAllItens() throws Throwable {
	    bootstrapThemePage.selectAllNone();
	}
	
	@When("^I click delete$")
	public void iClickDelete() throws Throwable {
	   bootstrapThemePage.clickDeleteButton();
	}

	@Then("^Will show a message to confirm delete$")
	public void willShowAMessageToConfirmDelete() throws Throwable {
	   
	}

	@When("^I click delete from popup$")
	public void iClickDeleteFromPopup() throws Throwable {
	    
	}

	@Then("^Will show a message after delete \"([^\"]*)\"$")
	public void willShowAMessageAfterDelete(String arg1) throws Throwable {
	    
	}
	
	@After(order = 1)
	public void screenshot(Scenario scenario) {		
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {			
			FileUtils.copyFile(file,new File("target\\screenshots\\"+scenario.getName()+".png"));
			System.out.print("Tirando Screenshot " + scenario.getId() + file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After(order = 0)
	public void tearDown() {
		
//		driver.quit();
	}
	
	


}
