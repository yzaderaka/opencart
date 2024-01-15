package stepDefenitions;


import pages.Header;
import pages.LoginPage;
import pages.RegistrationPage;

public class PageInitializier {

    public static Header header;
    public static LoginPage login;
    public static RegistrationPage registration;

    public static void initializePageObjects() {
        header = new Header();
        login=new LoginPage();
        registration=new RegistrationPage();

    }
}
