/**
 * 
 */
package com.dataworkshop.dataworkshopda;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.dataworkshop.dataworkshopda.entity.RawData;
import com.dataworkshop.dataworkshopda.entity.Status;
import com.dataworkshop.dataworkshopda.repository.RawDataRepository;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

/**
 * @author ramon
 *
 */
@QuarkusTest
public class DataResourceTest {
	
	@InjectMock
	RawDataRepository rawDataRepository;
	
	 @BeforeEach
	    public void setup() {
		 	RawData rawDataMock = new RawData("name", "description", null, LocalDateTime.of(2020, 1, 1, 0, 0), Status.STATUS_ACTIVE);
		 	List<RawData> resMock = new ArrayList<RawData>();
		 	resMock.add(rawDataMock);
	        Mockito.when(rawDataRepository.listAll()).thenReturn(resMock); 
	    }

	@Test
	public void testDataEndpoint() {
		given().when()
			.get("/data")
			.then()
			.statusCode(200)
			.body(is("[{\"id\":0,\"name\":\"name\",\"description\":\"description\",\"userId\":0,\"date\":[2020,1,1,0,0],\"state\":\"STATUS_ACTIVE\"}]"));
	}

}
