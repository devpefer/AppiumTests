public class TestDialer {

    private final AppiumConfig appiumConfig;

    public TestDialer(String deviceName, String appiumURL) {
        String appPackage = "com.android.dialer";
        String appActivity = "com.android.dialer.main.impl.MainActivity";
        String noReset = "true";

        appiumConfig = new AppiumConfig(deviceName, appiumURL, appPackage, appActivity, noReset);

    }

    public void marcaNumeroTelefonoById(String phoneNumber) {

        String numeroBoton="";

        appiumConfig.getDriver().findElementById("com.android.dialer:id/fab").click();

        for (int i = 0; i < phoneNumber.length(); i++) {
            switch (phoneNumber.charAt(i)) {
                case '0' -> numeroBoton = "zero";
                case '1' -> numeroBoton = "one";
                case '2' -> numeroBoton = "two";
                case '3' -> numeroBoton = "three";
                case '4' -> numeroBoton = "four";
                case '5' -> numeroBoton = "five";
                case '6' -> numeroBoton = "six";
                case '7' -> numeroBoton = "seven";
                case '8' -> numeroBoton = "eight";
                case '9' -> numeroBoton = "nine";
            }

            appiumConfig.getDriver().findElementById("com.android.dialer:id/" + numeroBoton).click();
        }
    }

    public void marcaNumeroTelefonoByXPath(String phoneNumber) {

        appiumConfig.getDriver().findElementByXPath("//android.widget.ImageButton[@resource-id='com.android.dialer:id/fab']").click();

        for (int i = 0; i < phoneNumber.length(); i++) {

            appiumConfig.getDriver().findElementByXPath("//android.widget.TextView[@text='" + phoneNumber.charAt(i) + "']").click();

        }
    }
}
