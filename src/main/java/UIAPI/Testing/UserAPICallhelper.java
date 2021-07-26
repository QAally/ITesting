package UIAPI.Testing;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class UserAPICallhelper {
	
	public static int createUser(String json) {
		String endpoint = "https://jsonplaceholder.typicode.com/users";
		int statusCode = 0;
		try {
			HttpPost post = new HttpPost(endpoint);
			CloseableHttpClient client = HttpClients.createDefault();
			StringEntity body = new StringEntity(json);
			body.setContentType("application/json");
			post.setEntity(body);
			CloseableHttpResponse response = client.execute(post);
			String responseString = EntityUtils.toString(response.getEntity());
			System.out.println("The response is - "+responseString);
			 statusCode = response.getStatusLine().getStatusCode();
			 assertEquals(statusCode, 201);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return statusCode;
	}
	
	public static List<UserDTO> getAllUsers() {
		String endpoint = "https://jsonplaceholder.typicode.com/users";
		List<UserDTO> userList = null;
		try {
			
			HttpGet request = new HttpGet(endpoint);
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("The response is "+result);
			userList = Utils.getListfromJson(result, UserDTO.class);
			assertEquals(statusCode, 200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userList;
	}
	
	public static UserDTO getAParticularUser(String id) {
		String endpoint = "https://jsonplaceholder.typicode.com/users/"+id;
		UserDTO user = null;
		try {
			
			HttpGet request = new HttpGet(endpoint);
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("The response is "+result);
			user = Utils.getObjectFromJson(result, UserDTO.class);
			assertEquals(statusCode, 200);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
}
