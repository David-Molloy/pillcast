package com.riis.pillcast;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

public class PillCastTimeSchedule {

	public Response response;
	public static String token;

	@Before
	public void setUp() throws Exception {
		token = Authenticator.getIdToken();
		System.out.println(token);
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		System.out.println("gql reponse" + response.asString());

	}

	@Test
	public void testTimeScheduleUpdateSuccess() {
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
}
