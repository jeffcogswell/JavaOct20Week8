package co.grandcircus.jsonsamples;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestJsonService {
	private RestTemplate restTemplate = new RestTemplate();
	
	public void testApiCall() {
		
		//String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=a561d8ad4284cda7ec8e29d354f1eb93";
		String url = "https://api.spacexdata.com/v4/launches/latest";
		
		String json = restTemplate.getForObject(url, String.class);
		
		System.out.println("JSON RESPONSE:");
		System.out.println(json);
	}
		
}
