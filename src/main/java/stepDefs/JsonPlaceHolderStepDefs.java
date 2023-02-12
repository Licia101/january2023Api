package stepDefs;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class JsonPlaceHolderStepDefs extends BaseSteps {

    Response getCommentsResponse;
    Response postCommentsResponse;
    DocumentContext requestBody;
    RequestBodyService requestBodyService;

    @Given("JsonPlaceHolder service is up and running")
    public void json_place_holder_service_is_up_and_running() {
        // Write code here that turns the phrase above into concrete actions
       setHeadersWithContentType();
       setEndpointPath(ServiceURL);
        Response getServiceResponse =getCall();
       assertThat(getServiceResponse.statusCode(), equalTo(200));
    }
    @When("Get request is sent to get a specific comment with {string}")
    public void get_request_is_sent_to_get_a_specific_comment_with(String id) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(CommentsURL + id);
        getCommentsResponse = getCall();

    }
    @Then("Specific comment details with {string}, {string}, {string} is returned with status code of {int}")
    public void specific_comment_details_with_is_returned_with_status_code_of(String id, String nam, String em, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
      assertThat(getCommentsResponse.statusCode(), equalTo(sCode));
      assertThat(getCommentsResponse.body().jsonPath().get("name"), equalTo(nam));
        assertThat(getCommentsResponse.body().jsonPath().get("email"), equalTo(em));
        assertThat(getCommentsResponse.body().jsonPath().get("id"), equalTo(Integer.parseInt(id)));


    }


    @When("i create a new comment with {string}, {string}, {string} and {string}")
    public void i_create_a_new_comment_with_and(String postid, String name, String email, String body) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(CommentsURL);
         requestBodyService = new RequestBodyService();
        requestBody = loadJsonTemplate(MakeACommentPayload);
        requestBodyService.setRequestBodyForComment(requestBody,postid,name,email,body);
        postCommentsResponse = getPostCall();
    }
    @Then("Details with {string}, {string}, {string} and {string} is returned with status code of {int}")
    public void details_with_and_is_returned_with_status_code_of(String postid, String name, String email, String body, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
      assertThat(postCommentsResponse.statusCode(), equalTo(sCode));
      assertThat(postCommentsResponse.body().jsonPath().get("postId"), equalTo(postid));
        assertThat(postCommentsResponse.body().jsonPath().get("name"), equalTo(name));
        assertThat(postCommentsResponse.body().jsonPath().get("email"), equalTo(email));
        assertThat(postCommentsResponse.body().jsonPath().get("body"), equalTo(body));

    }


}
