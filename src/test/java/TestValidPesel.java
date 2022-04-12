import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestValidPesel {
    String expectedBody;

    private String generateExpectedResult(String pesel, boolean isValid, String dateOfBirth, String gender) {

        expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" + isValid + ",\"dateOfBirth\":\"" + dateOfBirth + "T00:00:00\"," + "\"gender\":\"" + gender + "\",\"errors\":[]}";

        return expectedBody;
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyJanuary31st() {
        String pesel = "80013113577";
        String expectedBody = generateExpectedResult(pesel, true, "1980-01-31", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyMarch31st() {
        String pesel = "89033176351";
        String expectedBody = generateExpectedResult(pesel, true, "1989-03-31", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyNovember30st() {
        String pesel = "90113082220";
        String expectedBody = generateExpectedResult(pesel, true, "1990-11-30", "Female");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyJuly31st() {
        String pesel = "95073180599";
        String expectedBody = generateExpectedResult(pesel, true, "1995-07-31", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=95070480593");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyMarch01st() {
        String pesel = "99030123966";
        String expectedBody = generateExpectedResult(pesel, true, "1999-03-01", "Female");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=99030123966");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyMay31st() {
        String pesel = "01253105090";
        String expectedBody = generateExpectedResult(pesel, true, "2001-05-31", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=01251405093");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyAugust31st() {
        String pesel = "05283109057";
        String expectedBody = generateExpectedResult(pesel, true, "2005-08-31", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=05280609055");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyFebruary28th() {
        String pesel = "09222896152";
        String expectedBody = generateExpectedResult(pesel, true, "2009-02-28", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=09290996158");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturySeptember30th() {
        String pesel = "09293096152";
        String expectedBody = generateExpectedResult(pesel, true, "2011-09-30", "Female");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=11311188080");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyDecember31st() {
        String pesel = "12323121111";
        String expectedBody = generateExpectedResult(pesel, true, "2012-12-31", "Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=12321221110");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyJune30th() {
        String pesel = "17263095467";
        String expectedBody = generateExpectedResult(pesel, true, "2017-06-30", "Female");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=17262195465");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyFebruary22nd() {
        String pesel = "22222222222";
        String expectedBody = generateExpectedResult(pesel, true, "2022-02-22", "Female");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=22222222222\n");
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }
}





