package ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.utilities.ElementHighliter;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait ;
	@FindBy(xpath = "//button[contains(text(),'Check Out')]")
	WebElement checkOut;
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement updateCart;
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement removeProductFromcart;
	@FindBy(xpath = "//button[contains(text(),'Place order')]")
	WebElement placeOrder;
	@FindBy(id="responseBody")
	WebElement checkOutResponse;
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement moveToCart;
	@FindBy(xpath="//input[@class='card-text form-control']")
	WebElement quantity;
	@FindBy(xpath="//button[@class='btn btn-secondary']")
	WebElement closePopUp;
	@FindBy(xpath="//div[@id=\"responseBody\"]")
	WebElement updateResponse;
	
	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,30);
	}
	public void setQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
		
	}
	public boolean updateQuantity() {
		updateCart.click();
		String res=updateResponse.getText();
		if(res.startsWith("Quantity has"))
		{
			closePopUp.click();
			return true;
		}
		else 
			return false;
	
	}
	public boolean checkOut() {
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		ElementHighliter.highlite(driver, checkOut);
		checkOut.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By) checkOutResponse));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String response=checkOutResponse.getText();
		System.out.println("response="+response);
		if(response.startsWith("Checked"))
			return true;
		else 
			return false;
		
	}
	public void gotoCart() {
		ElementHighliter.highlite(driver, moveToCart);
		moveToCart.click();
	}

}
