package stepDefs;


import com.jayway.jsonpath.DocumentContext;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSteps {

  public Headers headers;
    private String endpointPath;
    private Response response;
    public DocumentContext requestBodyJson;
    public String ServiceURL;
    public String CommentsURL;
    public String MakeACommentPayload;
    public String MakeAPostPayload;

    public BaseSteps() {
        ServiceURL = "https://jsonplaceholder.typicode.com";
        CommentsURL = ServiceURL + "/comments/";
        MakeACommentPayload = "/payloads/commentsPayloads.json";
        MakeAPostPayload = "/payloads/postPayloads.json";
    }

    public void setHeaders(Headers value) { restHeaders();
        headers = value;
    }

    private void restHeaders() {
        headers = null;
    }

    public void setHeadersWithContentType() {
        headers = new Headers(
                new Header("Content-Type", "application/json"));
        setHeaders(headers);
    }

    protected URL getURL() {
        try {
            return new URL(endpointPath);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }
        public Response getCall() {

            response = RestAssured.given().log().all()
                  .relaxedHTTPSValidation()
                    .headers(headers)
                    .when().get(getURL())
                    .then().log().all().extract().response();
            return response;
        }

        public Response getPostCall () {
            response = RestAssured.given().log().all()
                    .relaxedHTTPSValidation().headers(headers)
                    .body(requestBodyJson.jsonString())
                    .when().post(getURL())
                    .then().log().all().extract().response();
            return response;
        }

        public void setEndpointPath (String endpointPath) {
            this.endpointPath = endpointPath;
        }

        public DocumentContext loadJsonTemplate (String path) {
            requestBodyJson = JsonPath.parse(this.getClass().getResourceAsStream(path));
            return requestBodyJson;
        }
            public void setRequestBodyJson(DocumentContext reqBody){
        this.requestBodyJson = reqBody;

            }


    }
 

