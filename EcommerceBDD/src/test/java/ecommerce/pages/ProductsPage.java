package ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.utilities.ElementHighliter;

public class ProductsPage {
	WebDriver driver;

	enum products {
		WRANGLERJEANS, RAYMONDSHIRT, IPHONEX, ONEPLUS, SAMSUNG, REFRIGERATOR, AC, PUMASHOES;
	}

	@FindBy(id = "quantity1")
	WebElement iphoneX;
	@FindBy(id = "quantity2")
	WebElement onePlus;
	@FindBy(id = "quantity3")
	WebElement samsung;
	@FindBy(id = "quantity4")
	WebElement refrigerator;
	@FindBy(id = "quantity5")
	WebElement ac;
	@FindBy(id = "quantity6")
	WebElement lgTv;
	@FindBy(id = "quantity7")
	WebElement wranglerJeans;
	@FindBy(id = "quantity8")
	WebElement raymondShirt;
	@FindBy(id = "quantity9")
	WebElement pumaShoes;
	@FindBy(id = "product1")
	WebElement iphonexCartBtn;
	@FindBy(id = "product2")
	WebElement onePluscartBtn;
	@FindBy(id = "product3")
	WebElement samsungCatBtn;
	@FindBy(id = "product4")
	WebElement refrigeratorcartBtn;
	@FindBy(id = "product5")
	WebElement acCartBtn;
	@FindBy(id = "product6")
	WebElement tvCartBtn;
	@FindBy(id = "product7")
	WebElement jeansCartBtn;
	@FindBy(id = "product8")
	WebElement shirtCartBtn;
	@FindBy(id = "product9")
	WebElement shoesCartBtn;
	@FindBy(id = "responseBody")
	WebElement isProductAdded;
	@FindBy(xpath = "//*[@id=\"exampleModalCenter\"]/div/div/div[2]/button")
	WebElement btn;

	public void selectProduct(String str, String qty) {
		products productName = products.valueOf(str);
		switch (productName) {
		case WRANGLERJEANS:
			addToCart(wranglerJeans, jeansCartBtn, qty);
			break;
		case RAYMONDSHIRT:
			addToCart(raymondShirt, shirtCartBtn, qty);
			break;
		case IPHONEX:
			addToCart(iphoneX, iphonexCartBtn, qty);
			break;
		case ONEPLUS:
			addToCart(onePlus, onePluscartBtn, qty);
			break;
		case SAMSUNG:
			addToCart(samsung, samsungCatBtn, qty);
			break;
		case REFRIGERATOR:
			addToCart(refrigerator, refrigeratorcartBtn, qty);
			break;
		case PUMASHOES:
			addToCart(pumaShoes, shoesCartBtn, qty);
			break;
		default:
			break;
		}
	}

	
	public ProductsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isProductAddedToCart() {
		if (isProductAdded.getText().startsWith("Your")) {
			ElementHighliter.highlite(driver, btn);
			btn.click();

			return true;
		} else {
			ElementHighliter.highlite(driver, btn);
			btn.click();

			return false;
		}

	}

	public void addToCart(WebElement product, WebElement cartBtn, String qty) {
		product.clear();
		product.sendKeys(qty);
		ElementHighliter.highlite(driver, cartBtn);
		cartBtn.click();

	}

}
