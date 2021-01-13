package fantasy;

import java.util.HashMap;
import java.util.Map;

public class gameWeekInfo {
	private int weekNum;
	
	public Map<String , Integer> mp;
	
	public gameWeekInfo() {
		mp = new HashMap<String , Integer>();
	}
	
	public void setWeekNum(int n) {
		this.weekNum = n;
	}
	
	public int getWeekNum() {
		return this.weekNum;
	}
}
