package co.grandcircus.spacexbuilder;

import java.util.List;

public class SpaceXLaunch {

	private String details;
	private String static_fire_date_utc;
	private SpaceXFairings fairings;
	private SpaceXLinks links;
	
	private int flight_number;
	
	/*
	private boolean tbd;
	private boolean net;
	
	private String[] ships;
	
	private List<String> payloads;
	
	private List<SpaceXCore> cores;
	
	//private    payloads;*/
	
	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public SpaceXLinks getLinks() {
		return links;
	}

	public void setLinks(SpaceXLinks links) {
		this.links = links;
	}

	public SpaceXFairings getFairings() {
		return fairings;
	}

	public void setFairings(SpaceXFairings fairings) {
		this.fairings = fairings;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatic_fire_date_utc() {
		return static_fire_date_utc;
	}

	public void setStatic_fire_date_utc(String static_fire_date_utc) {
		this.static_fire_date_utc = static_fire_date_utc;
	}
	
	
	
}
