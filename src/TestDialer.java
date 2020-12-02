import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestDialer {

    private String deviceName;
    private String appiumURL;
    private String appPackage;
    private String appActivity;
    private String noReset;
    private AppiumConfig appiumConfig;

    public TestDialer(String deviceName, String appiumURL) {
        deviceName = deviceName;
        appiumURL = appiumURL;
        appPackage = "com.android.dialer";
        appActivity = "com.android.dialer.main.impl.MainActivity";
        noReset = "true";

        appiumConfig = new AppiumConfig(deviceName, appiumURL, appPackage, appActivity, noReset);

    }

    public void marcaNumeroTelefonoById(String phoneNumber) {

        String numeroBoton="";

        appiumConfig.getDriver().findElementById("com.android.dialer:id/fab").click();

        for (int i = 0; i < phoneNumber.length(); i++) {
            switch (phoneNumber.charAt(i)) {
                case '0':
                    numeroBoton = "zero";
                    break;

                case '1':
                    numeroBoton = "one";
                    break;

                case '2':
                    numeroBoton = "two";
                    break;

                case '3':
                    numeroBoton = "three";
                    break;

                case '4':
                    numeroBoton = "four";
                    break;

                case '5':
                    numeroBoton = "five";
                    break;

                case '6':
                    numeroBoton = "six";
                    break;

                case '7':
                    numeroBoton = "seven";
                    break;

                case '8':
                    numeroBoton = "eight";
                    break;

                case '9':
                    numeroBoton = "nine";
                    break;
            }

            appiumConfig.getDriver().findElementById("com.android.dialer:id/" + numeroBoton).click();
        }
    }

    public void marcaNumeroTelefonoByXPath(String phoneNumber) {

        appiumConfig.getDriver().findElementByXPath("//android.widget.ImageButton[@resource-id=\'com.android.dialer:id/fab\']").click();

        for (int i = 0; i < phoneNumber.length(); i++) {

            appiumConfig.getDriver().findElementByXPath("//android.widget.TextView[@text=\'" + phoneNumber.charAt(i) + "\']").click();

        }
    }
}
