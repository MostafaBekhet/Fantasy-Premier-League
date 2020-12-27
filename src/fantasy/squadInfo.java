package fantasy;

import java.util.ArrayList;

public class squadInfo {
	private static int totalSquadValue = 100000000;
	private int curSquadValue = 0;
	private int numGoalKeaper = 0;
	private int numDefend = 0;
	private int numMidField = 0;
	private int numForward = 0;
	private String sUserMail = ""; 
	public ArrayList<playerInfo> sPlayerList;
	
	public squadInfo() {
		sPlayerList = new ArrayList<playerInfo>();
	}
	
	public void setCurSquadValue(int x) {
		this.curSquadValue = x;
	}
	
	public void setSquadUserMail(String x) {
		this.sUserMail = x;
	}
	
	public void setNumGoal(int x) {
		this.numGoalKeaper = x;
	}
	
	public void setNumDef(int x) {
		this.numDefend = x;
	}
	
	public void seNumtMidF(int x) {
		this.numMidField = x;
	}
	
	public void setNumForw(int x) {
		this.numForward = x;
	}
	
	
	/**
	 * @return the totalSquadValue
	 */
	public static int getTotalSquadValue() {
		return totalSquadValue;
	}
	
	public String getSquadUserMail() {
		return this.sUserMail;
	}
	
	public int getCurSquadValue() {
		return this.curSquadValue;
	}
	
	public int getNumGoal() {
		return this.numGoalKeaper;
	}
	
	public int getNumDef() {
		return this.numDefend;
	}
	
	public int geNumtMidF() {
		return this.numMidField;
	}
	
	public int getNumForw() {
		return this.numForward;
	}
	
}
