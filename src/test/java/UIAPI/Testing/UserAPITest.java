package UIAPI.Testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class UserAPITest {

	
	@Test
	public void getCreateNewUser() throws JsonGenerationException, JsonMappingException, IOException {
		UserDTO user = new UserDTO();
		user.setId(11);
		user.setName("Leanne Grahamtest");
		user.setUsername("test");
		user.setEmail("Sincere@april.biztest");
		user.setPhone("1-770-736-8031");
		user.setWebsite("test.org");
		AddressDTO add = new AddressDTO();
		add.setCity("Gwenborough");
		add.setStreet("Kulas Light");
		add.setSuite("Apt. 556");
		add.setZipcode("92998");
		GeoDTO geo = new GeoDTO();
		geo.setLat("-37.3159");
		geo.setLng("81.1496");
		add.setGeo(geo);
		CompanyDTO cmp = new CompanyDTO();
		cmp.setBs("harness");
		cmp.setCatchPhrase("Multi-layered");
		cmp.setName("Romaguera-Crona");
		user.setAddress(add);
		user.setCompany(cmp);
		String jsonRequest = Utils.convertToJson(user);
		int response = UserAPICallhelper.createUser(jsonRequest);
		assertEquals(response, 201);
	}
	
	@Test
	public void getAllUsers() {
		
		List<UserDTO> user = UserAPICallhelper.getAllUsers();
		assertTrue(user.size()>0);
	}
	

	@Test
	public void getAParticularUser() {
		
		UserDTO user = UserAPICallhelper.getAParticularUser("1");
		assertEquals(user.getId(), 1);
	}

}
