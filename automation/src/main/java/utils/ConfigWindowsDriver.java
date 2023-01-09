package utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ConfigWindowsDriver {

    private WindowsDriver driver = null;
    @BeforeClass
    public void openChromeWithDebuggerMode(){
        /**
         * Right Click on Chrome and Click on Properties > Shortcut > Target : add this after chrome.exe" --remote-debugging-port=9222 -- "%1"
         * Example: "C:\Program Files\Google\Chrome\Application\chrome.exe" --remote-debugging-port=9222 -- "%1"
         *
         */
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        cap.setCapability("platform","Windows");
        try {
            driver = new WindowsDriver(new URL("https://127.0.0.1:4723"),cap);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPass(){
        System.out.println("Hello WOrld");
    }

    @AfterClass
    public void closeChromeDebuggerMode(){

    }
}
