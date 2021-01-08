package fantasy;

public class playerInfo {
	private String pName;
	private String nationality;
	private String position;
	private String club;
	private int price;
	private int points = 0;
		
	/////// setters
	public void setpName(String n) {
		this.pName = n;
	}
	
	public void setNationality(String nation) {
		this.nationality = nation;
	}
	
	public void setPrice(int p) {
		this.price = p;
	}
	
	public void setClub(String c) {
		this.club = c;
	}
	
	public void setPosition(String pos) {
		this.position = pos;
	}
	
	public void setPoints(int p) {
		this.points = p;
	}
	
	
	//// getters
	public String getpName() {
		return this.pName;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getClub() {
		return this.club;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public int getPoints() {
		return this.points;
	}
}
