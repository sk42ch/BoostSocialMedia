package captchasolver;

import com.asprise.ocr.Ocr;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import com.asprise.*;

public class MegaTypers {
   private static WebDriver driver;

    @BeforeClass
    public void heatTheUrl(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.navigate().to("http://www.megatypers.com/login");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("itct1004@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("$$UAD22o");
        driver.findElement(By.xpath("//*[@id='lgn']")).click();

    }
    @Test
    public void solveCAPTCHA() throws InterruptedException, IOException, TesseractException {
        System.out.println("Hello World");
        Thread.sleep(5000);
      File src =   driver.findElement(By.xpath("//*[@id='logo']")).getScreenshotAs(OutputType.FILE);
      String path = System.getProperty("user.dir")+"/captcha/img1.png";
      FileHandler.copy(src,new File(path));

       // driver.findElement(By.xpath("//*[@id='w_link']/span[text()='Start Working']")).click();
        Thread.sleep(3000);
        ITesseract images = new Tesseract();
        String read = images.doOCR(new File(path));
        System.out.println(read);

    }

}
