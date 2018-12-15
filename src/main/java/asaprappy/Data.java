package asaprappy;

import java.io.Serializable;
import java.util.Vector;
import javafx.util.Pair;

public class Data implements Serializable {
	public static final long serialVersionUID = 1;
	private String fullName = "";
	private String screenName = "";
	private String email = "";
	private String song = "";
	private boolean active = false;
	
	//vector of pairs user and log in status
	private Vector<Pair<String, Boolean>> actives;
	
	/* Possible statuses:
	 * Login - for when an user logs in and needs to send it back to the server */
	private String status = "";
	
	public Data() {
		actives = new Vector<Pair<String, Boolean>>();
	}
	
	//getters and setters
	public void setStatus(String st) {
		status = st;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setFullname(String name) {
		fullName = name;
	}
	
	public String getFullname() {
		return fullName;
	}
	
	public void setScreename(String scrname) {
		screenName = scrname;
	}
	
	public String getScreename() {
		return screenName;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setSong(String s) {
		song = s;
	}
	
	public String getSong() {
		return song;
	}
	
	public void setActive(boolean a) {
		active = a;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void addActive(Pair<String, Boolean> p) {
		actives.add(p);
	}
	
	public void removeActive(String email) {
		for(int i = 0; i < actives.size(); i++) {
			if(actives.get(i).getKey().equals(email)) {
				Pair<String, Boolean> p = new Pair<String, Boolean>(email, false);
				actives.set(i, p);
			}
		}
	}
	
	public Vector<Pair<String, Boolean>> getActives() {
		return actives;
	}
}