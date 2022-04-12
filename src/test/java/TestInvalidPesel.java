import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestInvalidPesel {

    String expectedBody;

    private String generateExpectedResult(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage) {
        expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" + isValid + ",\"dateOfBirth\":\"" + dateOfBirth + "T00:00:00\"," + "\"gender\":\"" + gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" + errorMessage + "\"}]}";
        return expectedBody;
    }

    private String generateExpectedResult1(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage) {
        expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" + isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":" + gender + ",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" + errorMessage + "\"}]}";
        return expectedBody;
    }

    private String generateExpectedResult2(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage) {
        expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" + isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":\"" + gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" + errorMessage + "\"}]}";
        return expectedBody;
    }

    private String generateExpectedResult3(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage, String errorCode1, String errorMessage1, String errorCode2, String errorMessage2) {
        expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" + isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":\"" + gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" + errorMessage + "\"},{\"errorCode\":\"" + errorCode1 + "\",\"errorMessage\":\"" + errorMessage1 + "\"},{\"errorCode\":\"" + errorCode2 + "\",\"errorMessage\":\"" + errorMessage2 + "\"}]}";
        return expectedBody;
    }

    private String generateExpectedResult4(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage, String errorCode1, String errorMessage1) {
        expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" + isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":\"" + gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" + errorMessage + "\"},{\"errorCode\":\"" + errorCode1 + "\",\"errorMessage\":\"" + errorMessage1 + "\"}]}";
        return expectedBody;
    }

    @Test
    public void should_getInvalidPesel_with_errorCode_INVC() {
        String pesel = "11111111111";
        String expectedBody = generateExpectedResult(pesel, false, "1911-11-11", "Male", "INVC", "Check sum is invalid. Check last digit.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getInvalidPesel_with_errorCode_NBRQ() {

        String pesel = "abcdefghijk";
        String expectedBody = generateExpectedResult1(pesel, false, "null", "null", "NBRQ", "Invalid characters. Pesel should be a number.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getInvalidPesel_with_errorCode_errorCode_INVD() {
        String pesel = "71222978053";
        String expectedBody = generateExpectedResult2(pesel, false, "null", "Male", "INVD", "Invalid day.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getInvalidPesel_with_errorCode_INVL_andIsToShort() {
        String pesel = "5522297805";
        String expectedBody = generateExpectedResult1(pesel, false, "null", "null", "INVL", "Invalid length. Pesel should have exactly 11 digits.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getInvalidPesel_with_errorCode_INVL_TooLong() {
        String pesel = "123456789012";
        String expectedBody = generateExpectedResult1(pesel, false, "null", "null", "INVL", "Invalid length. Pesel should have exactly 11 digits.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void should_getInvalidPesel_with_errorCode_INVY_INVM_INVD() {

        String pesel = "00000000000";
        String expectedBody = generateExpectedResult3(pesel, false, "null", "Female", "INVY", "Invalid year.", "INVM", "Invalid month.", "INVD", "Invalid day.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }


    @Test
    public void should_getInvalidPesel_with_errorCode_INVY_INVM() {
        String pesel = "81600150504";
        String expectedBody = generateExpectedResult4(pesel, false, "null", "Female", "INVY", "Invalid year.", "INVM", "Invalid month.");
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }
}






