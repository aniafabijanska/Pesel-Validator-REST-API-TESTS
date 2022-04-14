import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestInvalidPesel {
    private void getDataForInvalidPesel_with_errorCode_INVC(String pesel, boolean isValid, String dateOfBirth, String gender,
                                                            String errorCode, String errorMessage) {

        String path = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel;
        if (dateOfBirth==null){
            dateOfBirth="T00:00:00";
        }
        String expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" +
                isValid + ",\"dateOfBirth\":\"" + dateOfBirth + "T00:00:00\"," + "\"gender\":\"" +
                gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" +
                errorMessage + "\"}]}";

        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVC() {
        String pesel = "11111111111";
        getDataForInvalidPesel_with_errorCode_INVC(pesel, false, "1911-11-11", "Male", "INVC", "Check sum is invalid. Check last digit.");
    }

    private void getDataForInvalidPesel_with_errorCodeNBRQOrINVL(String pesel, boolean isValid, String dateOfBirth, String gender,
                                                                 String errorCode, String errorMessage) {

        String path = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel;
        String expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" +
                isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":" +
                gender + ",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" +
                errorMessage + "\"}]}";
        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_NBRQ() {

        String pesel = "8902295678k";
        getDataForInvalidPesel_with_errorCodeNBRQOrINVL(pesel, false, null, null, "NBRQ", "Invalid characters. Pesel should be a number.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVL_andIsToShort() {
        String pesel = "5522297805";
        getDataForInvalidPesel_with_errorCodeNBRQOrINVL(pesel, false, null, null, "INVL", "Invalid length. Pesel should have exactly 11 digits.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVL_TooLong() {
        String pesel = "123456789012";
        getDataForInvalidPesel_with_errorCodeNBRQOrINVL(pesel, false, null, null, "INVL", "Invalid length. Pesel should have exactly 11 digits.");
    }

    private void getDataForInvalidPesel_with_errorCode_INVD(String pesel, boolean isValid, String dateOfBirth, String gender,
                                                            String errorCode, String errorMessage) {

        String path = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel;
        String expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" +
                isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":\"" +
                gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" +
                errorMessage + "\"}]}";

        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD() {
        String pesel = "71222978053";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_January32st() {
        String pesel = "80013213574";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_February29th() {
        String pesel = "09222996159";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_February30th() {
        String pesel = "20223022223";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Female", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_March32st() {
        String pesel = "89033276358";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_April31st() {
        String pesel = "22043145670";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_May32nd() {
        String pesel = "01253205097";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_June31st() {
        String pesel = "17263195464";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Female", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_July32nd() {
        String pesel = "95073280596";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_August32nd() {
        String pesel = "05283209054";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_September31st() {
        String pesel = "09293196159";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }


    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_October32nd() {
        String pesel = "33103296159";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }


    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_November31st() {
        String pesel = "90113182227";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Female", "INVD", "Invalid day.");
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVD_December32nd() {
        String pesel = "12323221118";
        getDataForInvalidPesel_with_errorCode_INVD(pesel, false, null, "Male", "INVD", "Invalid day.");
    }

    private void getDataForInvalidPesel_with_errorCode_INVY_INVM_INVD(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage, String errorCode1, String errorMessage1, String errorCode2, String errorMessage2) {
        String path = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel;
        String expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" +
                isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":\"" +
                gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" +
                errorMessage + "\"},{\"errorCode\":\"" + errorCode1 + "\",\"errorMessage\":\"" +
                errorMessage1 + "\"},{\"errorCode\":\"" + errorCode2 + "\",\"errorMessage\":\"" +
                errorMessage2 + "\"}]}";

        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVY_INVM_INVD() {
        String pesel = "00000000000";
        getDataForInvalidPesel_with_errorCode_INVY_INVM_INVD(pesel, false, null, "Female", "INVY", "Invalid year.", "INVM", "Invalid month.", "INVD", "Invalid day.");
    }

    private void getDataForInvalidPesel_with_errorCode_INVY_INVM(String pesel, boolean isValid, String dateOfBirth, String gender, String errorCode, String errorMessage, String errorCode1, String errorMessage1) {
        String path = "https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=" + pesel;
        String expectedBody = "{\"pesel\":\"" + pesel + "\",\"isValid\":" +
                isValid + ",\"dateOfBirth\":" + dateOfBirth + "," + "\"gender\":\"" +
                gender + "\",\"errors\":[{\"errorCode\":\"" + errorCode + "\",\"errorMessage\":\"" +
                errorMessage + "\"},{\"errorCode\":\"" + errorCode1 + "\",\"errorMessage\":\"" +
                errorMessage1 + "\"}]}";

        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getDataForInvalidPesel_with_errorCode_INVY_INVM() {
        String pesel = "81600150504";
        getDataForInvalidPesel_with_errorCode_INVY_INVM(pesel, false, null, "Female", "INVY", "Invalid year.", "INVM", "Invalid month.");
    }
}
