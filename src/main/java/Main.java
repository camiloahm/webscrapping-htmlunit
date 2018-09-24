import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HTMLParserListener;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws IOException {

        String target = "https://spokeswdpr.disney.com/spokes/?wsrp-navigationalState=search.html?searchMode=fullpage&ProxyServiceID=ID035_ID";

        final WebClient client = getConfiguredClient();
        final HtmlPage page = client.getPage(target);
        page.getBaseURL();

//        page.<HtmlInput>getHtmlElementById("LEGACY-login-username").setValueAttribute("f-cast-elastic");
//        page.<HtmlInput>getHtmlElementById("LEGACY-login-password").setValueAttribute("D1$NeY813");
//        page.<HtmlButton>getHtmlElementById("LEGACY-login-signin").click();
//        page.getForms();
    }


    private static WebClient getConfiguredClient() throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setTimeout(120000);
        webClient.setJavaScriptErrorListener(InternalErrorHandler.INSTANCE);
        webClient.setHTMLParserListener(InternalErrorHandler.INSTANCE);
        webClient.getCookieManager().clearCookies();
        Arrays.stream(cookies(webClient)).forEach(webClient.getCookieManager()::addCookie);
        return webClient;
    }


    private static Cookie[] cookies(WebClient client) throws IOException {

        return new Cookie[]{
                new Cookie("disney.com", "convId", "fbwSe_cf16bd26-88dd-b2eb-0966-fb52e98b5ff7"),
                new Cookie("disney.com", "enabledfeatures", "betaUI,tokenRenewal"),
                new Cookie("disney.com", "idp", "efs.disney.com:9031"),
                new Cookie("disney.com", "s_cc", "true"),
                new Cookie("disney.com", "s_sq", "%5B%5BB%5D%5D"),
                new Cookie("disney.com", "SMSESSION", "t6cmsigTepFkVwVV3aVwjZF4mGVvCuRVB0DruF4Vkix+af5KRqV1Xp9J5GybB/fPu07G5tOOfK2P+g4bLRlxm+n4pHybe/aYKxcSvmBd8QUI0lDgrUb/p6ak9mPCnEhnf+mZUm3TpBIvgcxcHKUuLpKJ8GrKH0my5Al8gvqvbrnSu1nO0oJGZ95SB97swxk5gTxTkKW7jqOKm8nq0u1axaYHfyL1SVPR5rDitQsx9q98Z2e24K3ve3rmfjSq7Phi0wbHqpYTwpY9qhN3OrzKsM+DMa+mqgyGIM2RUmirKudeCyoygjklpHaJyMm5GKKXbqq1hlfxISwgnFb2DbgrmGOMTZVNvuunBOeEHfetsmfcGSy1m/q2fsZ32BnwOXVmxOItddyqy+0z+zxA9c/htAtCaD8XnqciqPXclaVXrzC/j624AThoNs9k7XLRKLAwOGHsogsvLy1BuKFIXaiquNkRytuV4z4SG8HzatsCp2TQMf6C/CpX7jT9fS2VZPhUah1NcY1u2vRzzbGH8KmptlXo3tKkaMJwdp83ycGgUcvEHDngYASi5LpFYYDVL16E9Yw47lWQRuAN7cvJc+tFd4QKnPRupY93+lWTaPhqi6xBLp+JfjpySl1ZcakygrRkVzYI7Bu4wscdjDAN5lurCys9QSsGkgO9JrmXC3FFLp8DxfVhE9mk2eC2/01iCMlJaQaRp5fV1Lkl6f2sBYF1DRbDmJwmw1EvHZHaIMf6J9DlOchl4eRuoN7VAF//PryVf48lfarkC3RNX/4KTFiHjzu9M3tjWGA9Krng15qlxjYNvfVmmzrJLmB8OFa4vuqEL35u8B0ubJg7hUlXUb6xnrock2T8E430XHoMrlNEErDQKC9Vio+dT1ZbI2xpKaNVsOioiFsyJ35OV8LCZvIOKH3HssPqhr8qttO1gpMjCAk7AbQORettQnrQbnBXLCJwQqJBHtXz9U0IhiUyIlfwIw=="),
                new Cookie("disney.com", "ssoauth", "T1RLAQKipYIu5SzWafrL_ATv-m0th3lX-hAlBu6aR958dwH3kdTOyGKxAADg5BZIjknn5dYXEnsN20340VAMWPxR8yG0ciIzvZ5y9WH4-XtIagqldgwY7YufXVvWPMxzL9evLUHegWZSHhmWdvclTLk43iNiVD2LGbEeo5e7U6wNkteifjH1RDYjwoKhhI_1r1RS94e5v10hNxq6v0kYHCvOTsbZHnkxJG3EXCI_wSYX9vnMSU6ai4onyYQ7_4t8lMz3k4QOUC2iXd-HY1TVJklOKfIF8x1KnwGcPt3NdhC4_4KBRfO9gki4y5fRgyCS_o8yDT91u6nIMwUFwZrLu5iGcpJSuwqqh5L1zpQ*"),
                new Cookie("disney.com", "stateInfo", "%7B%22resume%22%3A%22%2Fidp%2FfbwSe%2FresumeSAML20%2Fidp%2FstartSSO.ping%22%2C%22spentity%22%3A%22spokes-wdpr-prod%22%7D"),
                new Cookie("disney.com", "AWSALB", "VrcX3OjARIk8Hf44j4D+s4WfhTLDIAZw+0PpyzEuDvt7SKdDc0+ETpHUMTmJ3DSebhupvmfuFgCbgxqCZncNS2eM6yGp7I1qzBxo7/+iwJDuPohDFJcVfsz+WYC7", "/", new Date(1538153247), false),
                new Cookie("disney.com", "JSESSIONID", "B352EC2B14C9CC815B70044B90590E62", "/spokes", new Date(0), false)
        };

    }


    static class InternalErrorHandler implements JavaScriptErrorListener, HTMLParserListener {
        static InternalErrorHandler INSTANCE = new InternalErrorHandler();

        @Override
        public void scriptException(HtmlPage page, ScriptException scriptException) {
            System.out.println(scriptException);
        }

        @Override
        public void timeoutError(HtmlPage page, long allowedTime, long executionTime) {
            System.out.println(executionTime);
        }

        @Override
        public void malformedScriptURL(HtmlPage page, String url, MalformedURLException malformedURLException) {
            System.out.println(malformedURLException);
        }

        @Override
        public void loadScriptError(HtmlPage page, URL scriptUrl, Exception exception) {
            System.out.println(exception);
        }

        @Override
        public void error(String message, URL url, String html, int line, int column, String key) {
            System.out.println(message);
        }

        @Override
        public void warning(String message, URL url, String html, int line, int column, String key) {
            System.out.println(message);
        }
    }

}

