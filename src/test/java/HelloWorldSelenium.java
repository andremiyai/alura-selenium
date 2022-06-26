import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {

    @BeforeEach
    public void inicializar(){
        System.setProperty("webdriver.chrome.driver","/Users/andremiyai/IdeaProjects/alura-selenium/chromedriver");
    }

    @Test
    public void hello(){
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/leiloes");
        browser.quit();
    }
}
