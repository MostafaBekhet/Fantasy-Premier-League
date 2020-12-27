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
	
	public void addPlayer(parentLists pl) {
		
		playerObj = new playerInfo();
		
		System.out.print("Please enter your player name: ");
		tempString = sc.next();
		playerObj.setpName(tempString);
		
		System.out.print("Please enter player's Nationality: ");
		tempString = sc.next();
		playerObj.setNationality(tempString);
		
		System.out.print("Player's position, Please enter 1,2,3 or 4 for Goalkeaper,Dedender,Midfield or Forward respectivley: ");
		tempInt = sc.nextInt();
		
		if(tempInt == 1) {
			playerObj.setPosition("Goalkeaper");
		}else if (tempInt == 2) {
			playerObj.setPosition("Dedender");
		}else if (tempInt == 3) {
			playerObj.setPosition("Midfield");
		}else if (tempInt == 4) {
			playerObj.setPosition("Forward");
		}else {
			System.out.print("Invalid choice!");
			return;
		}
		
		System.out.print("Please enter your player's club: ");
		tempString = sc.next();
		playerObj.setClub(tempString);
		
		System.out.print("Please enter your player's price: ");
		tempInt = sc.nextInt();
		playerObj.setPrice(tempInt);
		
		if(!playerD.find(pl , playerObj.getpName() , playerObj.getNationality())) {
			pl.playerList.add(playerObj);
			playerD.modifyData(pl);
			
			System.out.println("Player added Successfully!");
			
		}else {
			System.out.println("Player already exists!");
		}
		
	}
	
	public void createSquad(parentLists pl , String userMail) {
		
		squadObj = new squadInfo();
		squadObj.setSquadUserMail(userMail);
		
		System.out.println("Here is a list of available Players..");
		playerD.print(pl);
		
		System.out.println("You have to pick 15 player(Goalkeaper 2, Dedender 5, Midfield 5, Forward 3)");
		
		for(int i = 0; i < 15; ++i) {
			
			playerObj = new playerInfo();
			
			System.out.print("Please enter right playerName to add to your squad: ");
			tempString = sc.next();
			playerObj = (playerInfo) playerD.getMamber(pl, tempString);
			if(playerObj != null) {
				
				if(playerObj.getPosition().equals("GoalKeaper")) {
					squadObj.setNumDef(squadObj.getNumGoal() + 1);
				}else if(playerObj.getPosition().equals("Dedender")) {
					squadObj.setNumDef(squadObj.getNumDef() + 1);
				}else if(playerObj.getPosition().equals("Midfield")) {
					squadObj.setNumDef(squadObj.geNumtMidF() + 1);
				}else if(playerObj.getPosition().equals("Forward")) {
					squadObj.setNumDef(squadObj.getNumForw() + 1);
				}
				
				squadObj.setCurSquadValue(playerObj.getPrice() + squadObj.getCurSquadValue());
				
				if(squadObj.getNumGoal() <= 2 && squadObj.getNumDef() <= 5 && squadObj.geNumtMidF() <= 5 && squadObj.getNumForw() <= 3) {
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
