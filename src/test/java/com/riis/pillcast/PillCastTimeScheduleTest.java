package com.riis.pillcast;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PillCastTimeScheduleTest {

	private Response response;
	private String token;

	/* Test with morning(h1),midday(h12),evening(h17) and bedtime(h21) pill time */
	@Test
	public void test01_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule1.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h13) pill time */
	@Test
	public void test02_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule2.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h9),midday(h15),evening(h18) and bedtime(h22) pill time */
	@Test
	public void test03_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule3.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with midday(h13) and bedtime(h22) pill time */
	@Test
	public void test04_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule4.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h10) and bedtime(h22) pill time */
	@Test
	public void test05_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule5.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with bedtime(h21) pill time and query variable changed to $bedtime */
	@Test
	public void test06_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule6.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h11),midday(h16),evening(h19)*/
	@Test
	public void test07_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule7.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h11:m05),midday(h16:m15),evening(h19:m23)*/
	@Test
	public void test08_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule7.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h3:m05),midday(h14:m55),evening(h16:m30)*/
	@Test
	public void test09_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule9.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with morning(h6:m08),midday(h14:m09),evening(h16:m30)*/
	@Test
	public void test10_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule10.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with midday(h13:m09),evening(h16:m30) with query variable changed to $midday*/
	@Test
	public void test11_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule11.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	
	/* Test with evening(h16:m15),bedtime(h23:m30) with query changed to $evening*/
	@Test
	public void test12_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule11.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with evening(h16:m15),bedtime(h23:m30) query variable changed to $evening*/
	@Test
	public void test13_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule13.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with evening(h17:m07) with query variable changed to $evening*/
	@Test
	public void test14_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule14.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	/* Test with evening(h17:m15) with query variable changed to $evening*/
	@Test
	public void test15_TimeScheduleUpdateSuccess()throws Exception {
		token = Authenticator.getIdToken();
		String body = IOUtils.toString(new FileInputStream(new File("src/main/resources/timeschedule15.json")), StandardCharsets.UTF_8);
		Header header = new Header("Authorization", "Bearer " + token);
		response = given().contentType("application/json").header(header).body(body).accept("application/json").when().post("https://pillcast-alpha-api.herokuapp.com/p/GQL");
		//System.out.println("gql reponse" + response.asString());
		response.then().statusCode(200);
		response.then().body("data.upsert_schedule.id",Matchers.notNullValue());
	}
	
	
}
