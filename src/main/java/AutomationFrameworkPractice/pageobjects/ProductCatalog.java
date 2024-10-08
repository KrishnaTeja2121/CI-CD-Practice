package AutomationFrameworkPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFrameworkPractice.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
     WebDriver driver;
	 public ProductCatalog(WebDriver driver){
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	By spinner=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
	}	
	
	public WebElement getproductByName(String productName) {
		return getProductsList().stream().filter(
				product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public void addProductToCart(String productName) {
		WebElement prod=getproductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	


	

}
