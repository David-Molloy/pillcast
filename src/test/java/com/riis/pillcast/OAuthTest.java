package com.riis.pillcast;

import static com.jayway.restassured.RestAssured.given;
import static com.riis.pillcast.Constants.ACCESS_TOKEN;
import static com.riis.pillcast.Constants.CONSUMER_KEY;
import static com.riis.pillcast.Constants.CONSUMER_SECRET;
import static com.riis.pillcast.Constants.SECRET_TOKEN;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class OAuthTest {
	
	public static Response response = null;
	public static final String BODY = "{\"device\": \"Lakshmi's iPhone\",\"password\": \"qwert\",\"scope\": \"openid offline_access\",\"grant_type\": \"password\",\"username\": \"sam@patient.com\",\"client_id\": \"1PumcQ7cfMWBllkI4IMb2VCKx7XQozOy\",\"connection\": \"Username-Password-Authentication\"}";

	@Before
	public void setUp() {
		response = given().contentType("application/json").auth()
				.oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, SECRET_TOKEN, OAuthSignature.HEADER).body(BODY).when()
				.post("https://totyio.auth0.com/oauth/ro");
	}

	@Test
	public void testOAuthStatusCode200() {
		response.then().statusCode(200);
	}

	@Test
	public void testOAuthResponseTokenTypeIsBearer() {
		response.then().body("token_type", equalTo("bearer"));
	}

	@Test
	public void testOAuthSetIDToken() {
		JsonPath responseBody = response.getBody().jsonPath();
		System.out.println(responseBody.get("id_token").toString());
		response.then().body("id_token", Matchers.notNullValue());
	}

}
