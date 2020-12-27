package fantasy;

public class userInfo {
	private String name;
	private String mail;
	private String password;
	private String teamName;
	
	/////// setters
	public void setName(String n) {
		this.name = n;
	}
	
	public void setMail(String m) {
		this.mail = m;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public void setTeamName(String team) {
		this.teamName = team;
	}
	
	
	//// getters
	public String getName() {
		return this.name;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
}
