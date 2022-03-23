import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class Test_GET_Response_BDD {
    void GenerateExpectedResult(){}

}
    /*
    @Test
    public void testGetRequest_response_bdd() {
        String expectedBodyText = "{\n" +
                "  \"pesel\": \"88080808086\",\n" +
                "  \"isValid\": true,\n" +
                "  \"dateOfBirth\": \"1988-08-08T00:00:00\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"errors\": []\n" +
                "}";

        when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=88080808086\n")
                .then()
                .extract()
                .asString()
                .equals(expectedBodyText);
    }

    @Test
    public void testGetRequest_responseBody_bdd() {
        String expectedContent = "{\"pesel\":\"333333333\",\"isValid\":false,\"dateOfBirth\":null,\"gender\":null,\"errors\":[{\"errorCode\":\"INVL\",\"errorMessage\":\"Invalid length. Pesel should have exactly 11 digits.\"}]}";

        when()
                .get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=333333333")
                .then()
                .body(equalTo(expectedContent));
    }
}*/
