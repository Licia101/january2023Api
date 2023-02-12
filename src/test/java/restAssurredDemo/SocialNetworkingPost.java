package restAssurredDemo;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
public class SocialNetworkingPost {

 //   @Test
    public void getSpecificSocialNetworkingPost() {
        given().contentType(ContentType.JSON).log().all().
                when().get("https://jsonplaceholder.typicode.com/posts/6").
                then().statusCode(200).log().all().
                body("title", is("dolorem eum magni eos aperiam quia")).
                body("body", is("ut aspernatur corporis harum nihil quis provident sequi\nmollitia nobis aliquid molestiae\nperspiciatis et ea nemo ab reprehenderit accusantium quas\nvoluptate dolores velit et doloremque molestiae"));
    }
    @Test
    public void createASocialNetworkingPost(){
        HashMap<String, String> PostRequestBody = new HashMap<>();
        PostRequestBody.put("userId", "1");
        PostRequestBody.put("title", "My last holiday in japan");
        PostRequestBody.put("body", "I went holiday with my family , we had a good time. It was in the winter");

        given().contentType(ContentType.JSON).log().all().with().body(PostRequestBody).
                when().post("https://jsonplaceholder.typicode.com/posts").
                then().statusCode(201).log().all().
                body("title", is("My last holiday in japan"));
    }
}
