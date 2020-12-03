package co.grandcircus.spacexbuilder;

import java.util.List;

public class SpaceXFairings {
	private boolean reused;
	private boolean recovery_attempt;	
	private List<String> ships;
	
	public boolean isReused() {
		return reused;
	}
	public void setReused(boolean reused) {
		this.reused = reused;
	}
	public boolean isRecovery_attempt() {
		return recovery_attempt;
	}
	public void setRecovery_attempt(boolean recovery_attempt) {
		this.recovery_attempt = recovery_attempt;
	}
	public List<String> getShips() {
		return ships;
	}
	public void setShips(List<String> ships) {
		this.ships = ships;
	}
	
	
}
