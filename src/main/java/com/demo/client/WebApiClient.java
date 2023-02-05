package com.demo.client;

import com.demo.core.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class WebApiClient {

    private static final Logger logger = LogManager.getLogger(WebApiClient.class);
    private RequestSpecBuilder builder;

    public WebApiClient(String baseUri) {
        builder = new RequestSpecBuilder();
        builder.setBaseUri(baseUri);
        builder.addHeader("Content-Type", "application/json; charset=utf-8");
        builder.addHeader("Accept", "application/json");
        builder.addFilter(new LoggingFilter());
        logger.info("Created new instance of WebApiClient, ThreadId : " + Thread.currentThread().getId());
    }

    public Response execute(Object request, Map<String, String> headers, String endPoint, String httpMethod) {

        logger.info("Calling execute method, ThreadId : " + Thread.currentThread().getId());
        if(request != null) {
            builder.setBody(request);
        }

        if(headers != null && !headers.isEmpty()) {
            builder.addHeaders(headers);
        }

        Response httpResponse = RestAssured.given()
                .spec(builder.build()).log().all()
                .request(Method.valueOf(httpMethod), endPoint);

        httpResponse.then().log().all();

        return httpResponse;
    }

}
