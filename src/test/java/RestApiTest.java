import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class RestApiTest {

    String expectedBody;

    private String checkPriseOfGold(String date, String thePriceOfGold) {

        expectedBody = "[{\"data\":\"" + date + "\",\"cena\":" + thePriceOfGold + "}]";

        return expectedBody;
    }

    @Test
    public void getValidPriceOfGold2013January2nd() {
        String date = "2013-01-02";
        String thePriceOfGold = "165.83";
        checkPriseOfGold(date, thePriceOfGold);
        Response response = get("http://api.nbp.pl/api/cenyzlota/" + date);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getValidPriceOfGold2017January2nd() {
        String date = "2017-01-02";
        String thePriceOfGold = "155.76";
        checkPriseOfGold(date, thePriceOfGold);
        Response response = get("http://api.nbp.pl/api/cenyzlota/" + date);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    private void getPhotoId(int i) {

        String path = "https://api.pexels.com/v1/photos/2014422";
        String expectedBody = "{\"id\":2014422,\"width\":3024,\"height\":3024,\"url\":\"" +
                "https://www.pexels.com/photo/brown-rocks-during-golden-hour-2014422/\",\"" +
                "photographer\":\"Joey Farina\",\"photographer_url\":\"https://www.pexels.com/@joey\"" +
                ",\"photographer_id\":680589,\"avg_color\":\"#978E82\",\"src\":{\"original\":\"" +
                "https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg\",\"large2x\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026dpr=2\\u0026h=650\\u0026w=940\",\"large\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026h=650\\u0026w=940\",\"medium\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026h=350\",\"small\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026h=130\",\"portrait\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026fit=crop\\u0026h=1200\\u0026w=800\",\"landscape\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026fit=crop\\u0026h=627\\u0026w=1200\",\"tiny\":" +
                "\"https://images.pexels.com/photos/2014422/pexels-photo-2014422.jpeg?auto=compress\\u0026cs=tinysrgb\\u0026dpr=1\\u0026fit=crop\\u0026h=200\\u0026w=280\"},\"alt\":\"Brown Rocks During Golden Hour\"}";
        Response response = get(path);
        String actualBody = response.getBody().asString();
        Assert.assertEquals(actualBody, expectedBody);
    }

    @Test
    public void getPhotoId() {

        int i = 2014422;
        getPhotoId(2014422);
    }
}






