package fantasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class adminUserInterAction {
	private Scanner sc = new Scanner(System.in);
	private Map<String , Integer> mp;
	private playerDataController playerD = new playerDataController();
	private gameWeekInfo gWeekObj;
	
	public Map<String , Integer> addEvent(parentLists pList) {
		int c;
		String s;
		String pos;
		mp = new HashMap<String  , Integer>();
		while(true) {
			System.out.println("Enter 0 if no events to add\n"
							 + "Please Enter 1 if player played less than or at most 60 min\n"
					         + "Please Enter 2 if player played more than 60 min\n"
					         + "Please Enter 3 if player scored a goal\n"
					         + "Please Enter 4 if player assisted a goal\n"
					         + "Please Enter 5 if player has a clean sheet\n"
					         + "Please Enter 6 if player got a yellow card\n"
					         + "Please Enter 7 if player got a red card\n"
					         + "Please Enter 8 if Goalkeaper saved a penalty\n"
					         + "Please Enter 9 if Goalkeaper missed a penalty\n"
					         + "Please Enter 10 if player scored a goal in his team");
			c = sc.nextInt();
			
			if(c == 0) {
				break;
			}
			
			System.out.print("Please Enter player name: ");
			s = sc.next();
			
			pos = playerD.getMamber(pList, s).getPosition();
			
			if(c == 1) {
				mp.put(s, 1);
			}else if(c == 2) {
				mp.put(s, 2);
			}else if(c == 3) {
				
				if(pos.equals("Defender")) {
					mp.put(s, 6);
				}else if(pos.equals("Midfield")) {
					mp.put(s, 5);
				}else if(pos.equals("Forward")) {
					mp.put(s, 4);
				}
	
			}else if(c == 4) {
				
				mp.put(s, 3);
				
			}else if(c == 5) {
				
				if(pos.equals("GoalKeaper")) {
					
					mp.put(s, 4);
					
				}else if(pos.equals("Defender")) {
					
					mp.put(s, 4);
					
				}else if(pos.equals("Midfield")) {
					
					mp.put(s, 1);
					
				}

			}else if(c == 6) {
				
				mp.put(s, -1);
				
			}else if(c == 7) {
				
				mp.put(s, -2);
				
			}else if(c == 8) {
				
				mp.put(s, 4);
				
			}else if(c == 9) {
				
				mp.put(s, -2);
				
			}else if(c == 10) {
				
				mp.put(s, -2);
				
			}else {
				System.out.println("Invalid Choice!");
			}
			
		}
		
		return mp;
	}
	
	public void endWeek(parentLists pl) {
		
		int temp;
		System.out.print("Please Enter this week number to end it: ");
		temp = sc.nextInt();
		
		gWeekObj = new gameWeekInfo();
		
		gWeekObj.setWeekNum(temp);
		
		for(squadInfo squadObj : pl.squadList) {
			
			String userMail = squadObj.getSquadUserMail();
			int squadPoints = 0;
			
			for(playerInfo playerObj: squadObj.sPlayerList) {
				squadPoints += playerObj.getPoints();
			}
			
			gWeekObj.mp.put(userMail, squadPoints);
			pl.gWeekList.add(gWeekObj);
			
		}
		
	}
	
}
