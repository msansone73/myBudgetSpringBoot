package br.com.msansone.mybudget.api;

import static io.restassured.RestAssured.get;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestSecuriyTests {

	@Test
	public void contextLoads() {
	}

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	@Test
	public void testUserFetchesSuccess() {
		/*
		get("/mybudget/security/user/1000")
				.then()
				.body("id", equalTo(1000))
				.body("name", equalTo("Marcio Sansone"))
				.body("email", equalTo("msansone@gmail.com"));
	*/
	}

}
