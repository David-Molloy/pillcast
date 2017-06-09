package com.riis.pillcast;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class OAuthTest {
	private static final String CONSUMER_KEY = "9W7ZyZ5Kngx6gGQDlQUeGsoIF";
	private static final String CONSUMER_SECRET = "y9gBf8BcpodStEYTSBsH1XT2RwKZnZMUDN3353oz3HxKpKY3hT";
	private static final String ACCESS_TOKEN = "865248402086514689-Oyhj4gD3Nw3mW4Qo0KqKwSp67JroxWu";
	private static final String SECRET_TOKEN = "vvNAcbn70cM5YDrEOHrcdFV6ZzQByQwsUHHSMtAbRa216";
	private static final String BODY = "{\"device\": \"Lakshmi's iPhone\",\"password\": \"qwert\",\"scope\": \"openid offline_access\",\"grant_type\": \"password\",\"username\": \"sam@patient.com\",\"client_id\": \"1PumcQ7cfMWBllkI4IMb2VCKx7XQozOy\",\"connection\": \"Username-Password-Authentication\"}";
	private static Response response = null;
	private static String ID_TOKEN = null;

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
		ID_TOKEN = responseBody.get("id_token");
		System.out.println(ID_TOKEN);
	}

}
