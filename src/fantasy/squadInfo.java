package fantasy;

import java.util.ArrayList;

public class squadInfo {
	private static int maxSquadValue = 100000000;
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
	
	public void setCurSquadValue(int curVal) {
		this.curSquadValue = curVal;
	}
	
	public void setSquadUserMail(String userMail) {
		this.sUserMail = userMail;
	}
	
	public void setNumGoal(int nGoal) {
		this.numGoalKeaper = nGoal;
	}
	
	public void setNumDef(int nDef) {
		this.numDefend = nDef;
	}
	
	public void seNumtMidF(int nMid) {
		this.numMidField = nMid;
	}
	
	public void setNumForw(int nFor) {
		this.numForward = nFor;
	}
	
	
	/**
	 * @return the totalSquadValue
	 */
	public int getMaxSquadValue() {
		return maxSquadValue;
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
