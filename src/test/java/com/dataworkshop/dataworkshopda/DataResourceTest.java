/**
 * 
 */
package com.dataworkshop.dataworkshopda;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 * @author ramon
 *
 */
@QuarkusTest
public class DataResourceTest {

	@Test
	public void testDataEndpoint() {
		given().when()
			.get("/data")
			.then()
			.statusCode(200)
			.body(is("[]"));
	}

}
