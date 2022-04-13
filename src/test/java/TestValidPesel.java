import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestValidPesel {
    private void generateExpectedResult(String pesel, boolean isValid, String dateOfBirth, String gender) {

        String path = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel;
        String expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" +
                isValid + ",\"dateOfBirth\":\"" +
                dateOfBirth + "T00:00:00\"," + "\"gender\":\"" +
                gender + "\",\"errors\":[]}";


        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyJanuary31st() {
        String pesel = "80013113577";
        generateExpectedResult(pesel, true, "1980-01-31", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyFebruary28th() {
        String pesel = "09222896152";
        generateExpectedResult(pesel, true, "2009-02-28", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyFebruary29th() {
        String pesel = "20222922227";
        generateExpectedResult(pesel, true, "2020-02-29", "Female");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyMarch31st() {
        String pesel = "89033176351";
        generateExpectedResult(pesel, true, "1989-03-31", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyApril30th() {
        String pesel = "22043045673";
        generateExpectedResult(pesel, true, "1922-04-30", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyMay31st() {
        String pesel = "01253105090";
        generateExpectedResult(pesel, true, "2001-05-31", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyJune30th() {
        String pesel = "17263095467";
        generateExpectedResult(pesel, true, "2017-06-30", "Female");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyJuly31st() {
        String pesel = "95073180599";
        generateExpectedResult(pesel, true, "1995-07-31", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyAugust31st() {
        String pesel = "05283109057";
        generateExpectedResult(pesel, true, "2005-08-31", "Male");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturySeptember30th() {
        String pesel = "09293096152";
        generateExpectedResult(pesel, true, "2009-09-30", "Male");
    }


    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyOctober31st() {
        String pesel = "33103196152";
        generateExpectedResult(pesel, true, "1933-10-31", "Male");
    }


    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCenturyNovember30st() {
        String pesel = "90113082220";
        generateExpectedResult(pesel, true, "1990-11-30", "Female");
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXICenturyDecember31st() {
        String pesel = "12323121111";
        generateExpectedResult(pesel, true, "2012-12-31", "Male");
    }
}
