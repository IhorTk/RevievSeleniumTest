package ProductStoryTest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver get(){
        String browser = ConfigurationReader.get("browser");
        WebDriver driver;
        switch (browser){
            case "chrome" ->{
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if(ConfigurationReader.get("headless").toLowerCase().equals("true")){
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-popur-bloking");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--lang=en-en");
                }
                driver = new ChromeDriver(options);
                if(ConfigurationReader.get("maximize").toLowerCase().equals("true")){
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
                }
                return driver;
            }
            case "firefox" ->{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            }
            case "edge" ->{
                if(!System.getProperty("os.name").toLowerCase().equals("windows")){
                    throw new WrongThreadException("Ваша операционная система не поддерживает Edge");
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                return driver;
            }
        }
        throw new WrongThreadException("WebDriver не выбран в конфигурационном файле configuration.properties");
    }
}
