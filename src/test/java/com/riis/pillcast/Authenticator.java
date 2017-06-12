package com.riis.pillcast;

import static com.jayway.restassured.RestAssured.given;
import static com.riis.pillcast.Constants.ACCESS_TOKEN;
import static com.riis.pillcast.Constants.BODY;
import static com.riis.pillcast.Constants.CONSUMER_KEY;
import static com.riis.pillcast.Constants.CONSUMER_SECRET;
import static com.riis.pillcast.Constants.SECRET_TOKEN;

import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class Authenticator {

	public static String getIdToken() {
		JsonPath responseBody = getResponse().getBody().jsonPath();
		String token = responseBody.get("id_token");
		//System.out.println(token);
		return token;
	}

	private static Response getResponse() {
		Response response = given().contentType("application/json").auth()
				.oauth(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, SECRET_TOKEN, OAuthSignature.HEADER).body(BODY).when()
				.post("https://totyio.auth0.com/oauth/ro");
		return response;
	}

}
