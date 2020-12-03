import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;

import java.time.Duration;

public class TestReloj {

    private final AppiumConfig appiumConfig;

    public TestReloj(String deviceName, String appiumURL) {
        String appPackage = "com.google.android.deskclock";
        String appActivity = "com.android.deskclock.DeskClock";
        String noReset = "true";

        appiumConfig = new AppiumConfig(deviceName, appiumURL, appPackage, appActivity, noReset);
    }

    public void establecerAlarmaByXPath(String hora,String minutos) {
        appiumConfig.getDriver().findElementByXPath("//rk[@content-desc='Alarma']").click();
        appiumConfig.getDriver().findElementByXPath("//android.widget.ImageButton[@resource-id='com.google.android.deskclock:id/fab']").click();

        MobileElement elementHour1 = appiumConfig.getDriver().findElementByXPath("//*[@content-desc='12']");
        MobileElement elementHour2 = appiumConfig.getDriver().findElementByXPath("//*[@content-desc='" + hora + "']");

        Point center1 = elementHour1.getCenter();
        Point center2 = elementHour2.getCenter();

        TouchAction tSwipe1 = new TouchAction(appiumConfig.getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withPosition(PointOption.point(center1.x,center1.y))
                        .withDuration(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(center2.x,center2.y))
                .release()
                .perform();

        MobileElement elementMinutes1 = appiumConfig.getDriver().findElementByXPath("//*[@content-desc='15']");
        MobileElement elementMinutes2 = appiumConfig.getDriver().findElementByXPath("//*[@content-desc='" + minutos + "']");
        Point center3 = elementMinutes1.getCenter();
        Point center4 = elementMinutes2.getCenter();

        TouchAction tSwipe2 = new TouchAction(appiumConfig.getDriver())
                .longPress(LongPressOptions.longPressOptions()
                        .withPosition(PointOption.point(center3.x,center3.y))
                        .withDuration(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(center4.x,center4.y))
                .release()
                .perform();
    }
}
