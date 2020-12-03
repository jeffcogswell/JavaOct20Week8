package co.grandcircus.propertiestest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieApiService {
	private RestTemplate restTemplate = new RestTemplate();

	// Here's one way to use the key inside the app
	@Value("${keys.api.themoviedb}")
	private String moviekey;
	
	// Watch the trailing slashes! If you have one here, don't add them later
	// so you don't end up with double-slashes as in
	// "https://api.themoviedb.org/3//genre/movie/list"
	private String baseurl = "https://api.themoviedb.org/3/";
	
	public void testApiCall() {
		// Build the url
		String url = baseurl + "genre/movie/list?api_key=" + moviekey;
		String json = restTemplate.getForObject(url, String.class);
		System.out.println("JSON RESPONSE:");
		System.out.println(json);
	}
	
	// Here's another way. You can let Spring piece together the URL for you
	public void testApiCall2() {
		// Start with a basic URL
		
		UriComponentsBuilder url = UriComponentsBuilder.fromUriString(
				baseurl + "genre/movie/list");
		
		// Add the query parameters
		url.queryParam("api_key", moviekey);
		// You can call queryParam many times e.g.
		// url.queryParam("name", "fred")
		
		// Let's print it out so we an see if it's right
		// Need to call .toUriString()
		System.out.println("Calling URL:");
		System.out.println(url.toUriString());
		
		// Make sure you call .toUriString() in the rest call
		String json = restTemplate.getForObject(url.toUriString(), String.class);
		
		// Print out the response
		System.out.println("JSON RESPONSE:");
		System.out.println(json);
		
		
	}
	
}
