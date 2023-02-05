package com.demo.webapi;

import com.demo.client.WebApiClient;
import com.demo.models.CreateUserRequest;
import com.demo.models.CreateUserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class UserWebApi {

    private WebApiClient client;

    public UserWebApi() {
        client = new WebApiClient("https://reqres.in");
    }

    public CreateUserResponse createUser(String name, String job) {
        CreateUserRequest request = CreateUserRequest.builder().name(name).job(job).build();
        Response response = client.execute(request, null, "/api/users", "POST");
        return response.as(CreateUserResponse.class);
    }

}
