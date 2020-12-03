package co.grandcircus.spacexbuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpacexApiService {
	private RestTemplate restTemplate = new RestTemplate();
	
	public void testApiCall() {
		
		String url = "https://api.spacexdata.com/v4/launches/latest";
		
		String json = restTemplate.getForObject(url, String.class);
		
		System.out.println("JSON RESPONSE:");
		System.out.println(json);
	}
	
	public void testApiCall2() {
		String url = "https://api.spacexdata.com/v4/launches/latest";
		
		SpaceXLaunch launch = restTemplate.getForObject(url, SpaceXLaunch.class);
		System.out.println("LAUNCH RESPONSE:");
		System.out.println(launch);
		System.out.println(launch.getDetails());
		System.out.println(launch.getStatic_fire_date_utc());
		System.out.println(launch.getFairings().isReused());
		System.out.println(launch.getFairings().getShips());
		System.out.println(launch.getLinks().getWebcast());
		System.out.println(launch.getLinks().getPatch().getLarge());
	}
	
	public SpaceXLaunch getLatestLaunch() {
		String url = "https://api.spacexdata.com/v4/launches/latest";
		
		SpaceXLaunch launch = restTemplate.getForObject(url, SpaceXLaunch.class);
		
		return launch;
	}

}
