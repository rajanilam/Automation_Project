package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class BasePage {

    public static WebDriver wd;
    public static Properties prop;

    //CONSTRUCTOR
    public BasePage() {
        try{
            prop=new Properties();
            FileInputStream ip=new FileInputStream("src/test/java/config/config.properties");
            prop.load(ip);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //page initiatlization method
    public void initialization(){
        String browsername=prop.getProperty("BROWSER"); //reading from
        if(browsername.equals("chrome")){
            //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            wd=new ChromeDriver();

        }
        wd.manage().window().maximize();
        wd.get(prop.getProperty("HOME_PAGE"));
    }
}
