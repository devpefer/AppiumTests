public class Main {

    public static void main(String[] args) {
        String deviceName = "Pixel_3a_API_30_x86";
        String appiumURL = "http://127.0.0.1:4723/wd/hub";

        //Test de App Telefono
        TestDialer testDialer = new TestDialer(deviceName,appiumURL);

        String phoneNumber = "658974125";
        testDialer.marcaNumeroTelefonoById(phoneNumber);

        TestDialer testDialer2 = new TestDialer(deviceName,appiumURL);

        String phoneNumber2 = "678458956";
        testDialer2.marcaNumeroTelefonoByXPath(phoneNumber2);

    }
}
