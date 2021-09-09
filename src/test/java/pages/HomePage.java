package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(className="jumbotron")
    WebElement bannerTitle;


    public HomePage() {
        PageFactory.initElements(wd,this);
    }


    public String getHomePageTitle(){
        return wd.getTitle();
    }

    public String getBannerTitle(){
        return bannerTitle.getText();
    }
}
