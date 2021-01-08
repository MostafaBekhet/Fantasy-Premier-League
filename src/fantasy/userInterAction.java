package fantasy;

import java.util.Scanner;

public class userInterAction {
	
	private playerInfo playerObj;
	private squadInfo squadObj;
	private Scanner sc = new Scanner(System.in);
	
	public int tempInt;
	public String tempString;
	
	public DataController userD = new userDataController();
	public DataController playerD = new playerDataController();
	public DataController squadD = new squadDataController();
	
	public boolean signIn(parentLists pl , String mail , String pass) {
		return userD.find(pl , mail, pass);
	}
	
	public void createSquad(parentLists pl , String userMail) {
		
		squadObj = new squadInfo();
		squadObj.setSquadUserMail(userMail);
		
		System.out.println("Here is a list of available Players..");
		playerD.print(pl);
		
		System.out.println("You have to pick 15 player(GoalKeaper 2, Defender 5, Midfield 5, Forward 3)");
		
		for(int i = 0; i < 15; ++i) {
			
			boolean can = false;
			boolean foundSamePlayer = false;
			playerObj = new playerInfo();
			
			System.out.print("Please enter right playerName to add to your squad: ");
			tempString = sc.next();
			playerObj = (playerInfo) playerD.getMamber(pl, tempString);
			if(playerObj != null) {
				
				for(playerInfo pObj : squadObj.sPlayerList) {
					if(pObj.getpName().equals(playerObj.getpName()))
						foundSamePlayer = true;
				}
				
				if(playerObj.getPosition().equals("GoalKeaper") && squadObj.getNumGoal() < 2 && !foundSamePlayer) {
					squadObj.setNumGoal(squadObj.getNumGoal() + 1);
					can = true;
				}else if(playerObj.getPosition().equals("Defender") && squadObj.getNumDef() < 5 && !foundSamePlayer) {
					squadObj.setNumDef(squadObj.getNumDef() + 1);
					can = true;
				}else if(playerObj.getPosition().equals("Midfield") && squadObj.geNumtMidF() < 5 && !foundSamePlayer) {
					squadObj.seNumtMidF(squadObj.geNumtMidF() + 1);
					can = true;
				}else if(playerObj.getPosition().equals("Forward") && squadObj.getNumForw() < 3 && !foundSamePlayer) {
					squadObj.setNumForw(squadObj.getNumForw() + 1);
					can = true;
				}
				
								
				if(squadObj.getNumGoal() <= 2 && squadObj.getNumDef() <= 5 && squadObj.geNumtMidF() <= 5 && squadObj.getNumForw() <= 3
						&& playerObj.getPrice() + squadObj.getCurSquadValue() <= squadObj.getMaxSquadValue() && can && !foundSamePlayer) {
										
					squadObj.setCurSquadValue(playerObj.getPrice() + squadObj.getCurSquadValue());
					
					squadObj.sPlayerList.add(playerObj);
					squadD.modifyData(pl);
					System.out.println("player added to your squad successfully!");
				}else {
					System.out.println("You can not add this player to your squad");
					--i;
				}
				
			}else {
				System.out.println("Invalid Player Name!");
				--i;
			}
			
		}
		
		pl.squadList.add(squadObj);
		squadD.modifyData(pl);
		
		System.out.println("Squad created successfully!");
		
	}
	
}
