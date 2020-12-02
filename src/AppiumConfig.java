import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumConfig {
    private AndroidDriver<AndroidElement> driver = null;
    private DesiredCapabilities capabilities;

    public AppiumConfig(String nombreDispositivo, String appiumURL, String appPackage, String appActivity, String noReset) {
        try {

            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, nombreDispositivo);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("noReset", noReset);

            driver = new AndroidDriver<>(new URL(appiumURL), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }
}
