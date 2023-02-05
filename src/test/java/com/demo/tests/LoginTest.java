package com.demo.tests;

import com.demo.client.WebApiClient;
import com.demo.models.CreateUserResponse;
import com.demo.webapi.UserWebApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private UserWebApi userWebApi;

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Running Before method, ThreadId : " + Thread.currentThread().getId());
        userWebApi = new UserWebApi();
    }

    @Test
    public void test1() throws InterruptedException {
        logger.info("Running test1, ThreadId : " + Thread.currentThread().getId());
        CreateUserResponse response = userWebApi.createUser("shahid", "qa lead");
        Assert.assertEquals(response.getName(), "shahid");
        Assert.assertEquals(response.getJob(), "qa lead");
        Thread.sleep(2000);
    }

    @Test
    public void test2() throws InterruptedException {
        logger.info("Running test2, ThreadId : " + Thread.currentThread().getId());
        CreateUserResponse response = userWebApi.createUser("rahul", "tech lead");
        Assert.assertEquals(response.getName(), "rahul");
        Assert.assertEquals(response.getJob(), "tech lead");
        Thread.sleep(2000);
    }

    @Test
    public void test3() throws InterruptedException {
        logger.info("Running test3, ThreadId : " + Thread.currentThread().getId());
        CreateUserResponse response = userWebApi.createUser("pratik", "architect");
        Assert.assertEquals(response.getName(), "pratik");
        Assert.assertEquals(response.getJob(), "architect");
        Thread.sleep(2000);
    }

    @Test
    public void test4() throws InterruptedException {
        logger.info("Running test4, ThreadId : " + Thread.currentThread().getId());
        CreateUserResponse response = userWebApi.createUser("sharvari", "qa specialist");
        Assert.assertEquals(response.getName(), "sharvari");
        Assert.assertEquals(response.getJob(), "qa specialist");
        Thread.sleep(2000);
    }

    @Test
    public void test5() throws InterruptedException {
        logger.info("Running test5, ThreadId : " + Thread.currentThread().getId());
        CreateUserResponse response = userWebApi.createUser("neha", "tech specialist");
        Assert.assertEquals(response.getName(), "neha");
        Assert.assertEquals(response.getJob(), "tech specialist");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterMethod() {
        //logger.info("Running after method, ThreadId : " + Thread.currentThread().getId());
    }
}
