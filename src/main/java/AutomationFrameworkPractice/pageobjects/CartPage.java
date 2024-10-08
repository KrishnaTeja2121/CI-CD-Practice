package AutomationFrameworkPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFrameworkPractice.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
     WebDriver driver;
	 public CartPage(WebDriver driver){
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(css=".cartSection h3")
		private List<WebElement> cartProducts;
	 
	 @FindBy(css=".totalRow button")
		WebElement checkOutEle;
	 
	 
	 public Boolean VerifyproductDisplay(String productName) {
		 Boolean match=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));		 
		return match;
		 
	 }
	 
	 public void gotoCheckout()	 {
		 checkOutEle.click();
	 }	 
	


	

}
