import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.HashMap;
import java.util.Map;

public class HelloFunction implements RequestHandler<Object, Object> {
    public HelloFunction() {
    }

    @Override
    public Object handleRequest(Object input, Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        try {
            final String pageContents = "CDMX";
            String output = String.format("{ \"message\": \"hello world\", \"location\":\"%s\" }", pageContents);
            responseEvent.setBody(output);
            responseEvent.setHeaders(headers);
            responseEvent.setStatusCode(200);
            return responseEvent;
        } catch (Exception e) {
            responseEvent.setBody("{}");
            responseEvent.setHeaders(headers);
            responseEvent.setStatusCode(500);
            return responseEvent;
        }
    }
}