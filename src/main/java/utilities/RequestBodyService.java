package utilities;

import com.jayway.jsonpath.DocumentContext;
import stepDefs.BaseSteps;

public class RequestBodyService extends BaseSteps {

    public void setRequestBodyForComment(DocumentContext requestBody, String pId, String nm, String em, String bdy) {
        requestBody.set("postId", pId);
        requestBody.set("name", nm);
        requestBody.set("email", em);
        requestBody.set("body", bdy);
       setRequestBodyJson(requestBody);

    }

    public void setRequestBodyForPost(DocumentContext requestBody, String title, String body, String userId) {
        requestBody.set("title", title);
        requestBody.set("body", body);
        requestBody.set("userId", userId);
        setRequestBodyJson(requestBody);

    }
}