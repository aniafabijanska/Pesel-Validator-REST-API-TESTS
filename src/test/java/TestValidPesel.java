
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class TestValidPesel {
   String expectedBody;

    private String GenerateExpectedResult (String pesel, boolean isValid, String dateOfBirth, String gender) {

        expectedBody = "{\"pesel\":\""+pesel+"\",\"isValid\":"+isValid+",\"dateOfBirth\":\""+dateOfBirth+"T00:00:00\","+ "\"gender\":\""+gender+"\",\"errors\":[]}";

        return expectedBody;
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXCentury_80013113577() {

        String pesel = "80013113577";
        String expectedBody = GenerateExpectedResult (pesel ,true,"1980-01-31","Male");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);

        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXCentury_85040171734() {
        String pesel = "85040171734";
        String expectedBody = GenerateExpectedResult(pesel,true, "1985-04-01","Male");

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);

    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCentury_89032176352() {
        String pesel = "89032176352";
        String expectedBody = GenerateExpectedResult(pesel, true,"1989-03-21", "Male");

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();

        Assert.assertEquals(actualBody,expectedBody);
    }

    @Test
    public void should_getValidBirthDate_when_peselIsFromXXCentury_90112682223() {
        String pesel = "90112682223";
        String expectedBody = GenerateExpectedResult (pesel, true, "1990-11-26", "Female");

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody,expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXCentury_95070480593() {
        GenerateExpectedResult("95070480593", true, "1995-07-04","Male");

        String expectedBody = "{\"pesel\":\"95070480593\",\"isValid\":true,\"dateOfBirth\":\"1995-07-04T00:00:00\",\"gender\":\"Male\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=95070480593");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXCentury_99030123966() {
        GenerateExpectedResult("99030123966", true, "1999-03-01","Female");


        String expectedBody = "{\"pesel\":\"99030123966\",\"isValid\":true,\"dateOfBirth\":\"1999-03-01T00:00:00\",\"gender\":\"Female\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=99030123966");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

   @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_01251405093() {
       GenerateExpectedResult("01251405093", true, "2001-05-14","Male");

        String expectedBody = "{\"pesel\":\"01251405093\",\"isValid\":true,\"dateOfBirth\":\"2001-05-14T00:00:00\",\"gender\":\"Male\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=01251405093");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_05280609055() {
        GenerateExpectedResult("05280609055", true, "2005-08-06","Male");

        String expectedBody = "{\"pesel\":\"05280609055\",\"isValid\":true,\"dateOfBirth\":\"2005-08-06T00:00:00\",\"gender\":\"Male\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=05280609055");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_09290996158() {

        GenerateExpectedResult("09290996158", true, "2009-09-09","Male");
        String expectedBody = "{\"pesel\":\"09290996158\",\"isValid\":true,\"dateOfBirth\":\"2009-09-09T00:00:00\",\"gender\":\"Male\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=09290996158");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_11311188080() {

        GenerateExpectedResult("11311188080", true, "2011-11-11","Female");
        String expectedBody = "{\"pesel\":\"11311188080\",\"isValid\":true,\"dateOfBirth\":\"2011-11-11T00:00:00\",\"gender\":\"Female\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=11311188080");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_12321221110() {

        GenerateExpectedResult("12321221110", true, "2012-12-12","Male");
        String expectedBody = "{\"pesel\":\"12321221110\",\"isValid\":true,\"dateOfBirth\":\"2012-12-12T00:00:00\",\"gender\":\"Male\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=12321221110");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_17262195465() {

        GenerateExpectedResult("17262195465", true, "2017-06-21","Female");

        String expectedBody = "{\"pesel\":\"17262195465\",\"isValid\":true,\"dateOfBirth\":\"2017-06-21T00:00:00\",\"gender\":\"Female\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=17262195465");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test

    public void should_getValidBirthDate_when_peselIsFromXXICentury_22222222222() {

        GenerateExpectedResult("22222222222", true, "2022-02-22","Female");

        String expectedBody = "{\"pesel\":\"22222222222\",\"isValid\":true,\"dateOfBirth\":\"2022-02-22T00:00:00\",\"gender\":\"Female\",\"errors\":[]}";

        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=22222222222\n");
        String actualBody = response.getBody().asString();


        Assert.assertEquals(actualBody,expectedBody);
    }

}



