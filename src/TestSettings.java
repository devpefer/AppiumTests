public class TestSettings {

    private final AppiumConfig appiumConfig;

    public TestSettings(String deviceName, String appiumURL) {
        String appPackage = "com.google.android.deskclock";
        String appActivity = "com.android.deskclock.DeskClock";
        String noReset = "true";

        appiumConfig = new AppiumConfig(deviceName, appiumURL, appPackage, appActivity, noReset);
    }
}