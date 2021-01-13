package fantasy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


class parentLists {

	public ArrayList<userInfo> userList;
	public ArrayList<playerInfo> playerList;
	public ArrayList<squadInfo> squadList;
	public ArrayList<gameWeekInfo> gWeekList;
	
	public parentLists() {
		userList = new ArrayList<userInfo>();
		playerList = new ArrayList<playerInfo>();
		squadList = new ArrayList<squadInfo>();
		gWeekList = new ArrayList<gameWeekInfo>();
	}
}

public class SystemController {
	private int choice;
	public boolean signed = false;
	public int tempInt;
	public String tempString;
	
	private userInterAction userInter;
	private adminUserInterAction adminUserInter;
	private DataController userData;
	private DataController playerData;
	private DataController squadData;
	private DataController gameWeekData;
	private userInfo userObj;
	private playerInfo playerObj;
	private parentLists pList;
	private String CurrentUserMail;
	private Scanner sc;
	
	/////// setters
	public void setChoice(int ch) {
		this.choice = ch;
	}
	
	public void setCurUserMail(String s) {
		this.CurrentUserMail = s;
	}
	
	//// getters
	public int getChoice() {
		return this.choice;
	}
	
	public String getCurUserMail() {
		return this.CurrentUserMail;
	}
	
	public void run() {
				
		try {
			
			userInter = new userInterAction();
			
			pList = new parentLists();
					
			userData = new userDataController();
			userData.retriveData(this.pList);
			
			playerData = new playerDataController();
			playerData.retriveData(this.pList);
			
			squadData = new squadDataController();
			squadData.retriveData(this.pList);
			
			gameWeekData = new gameWeekController();
			gameWeekData.retriveData(this.pList);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			System.out.print("Plese enter 1 to Login, 2 to register, 3 to exit, 4 to Login as Admin User: ");
			
			sc = new Scanner(System.in);
			tempInt = sc.nextInt();
			
			setChoice(tempInt);
			
			if(getChoice() == 1) {
				String mail , pass;
				System.out.print("Please enter your mail: ");
				mail = sc.next();
				setCurUserMail(mail);
				
				System.out.print("Please enter your password: ");
				pass = sc.next();
				
				if(userInter.signIn(this.pList , mail, pass)) {
					signed = true; 
					System.out.println("Login Succefully!");
				}else {
					System.out.println("Incorrect mail or password!");
				}
				
			}else if(getChoice() == 2) {
				System.out.print("Please enter your name: ");
				
				userObj = new userInfo();
				
				tempString = sc.next();
				userObj.setName(tempString);
				
				System.out.print("Please enter your mail: ");
				tempString = sc.next();
				userObj.setMail(tempString);
				
				System.out.print("Please enter your password: ");
				tempString = sc.next();
				userObj.setPassword(tempString);
				
				System.out.print("Please enter your favourite premier league team: ");
				tempString = sc.next();
				userObj.setTeamName(tempString);
				
				addUser(userObj);
								
			}else if(getChoice() == 3) {
				break;
			
			}else if(getChoice() == 4) {
				String mail , pass;
				System.out.print("Please enter Admin mail: ");
				mail = sc.next();
				
				System.out.print("Please enter Admin password: ");
				pass = sc.next();
				
				if(mail.equals("admin") && pass.equals("admin")) {
					
					adminUserInter = new adminUserInterAction();
					
					System.out.print("If you want to End this week press 1 or 2 to Add Event: ");
					tempInt = sc.nextInt();
					
					if(tempInt == 1) {
						
						adminUserInter.endWeek(this.pList);
												
						this.gameWeekData.modifyData(this.pList);
						
					}else if(tempInt == 2) {
					
						Map<String , Integer> mp = adminUserInter.addEvent(this.pList);
						
						this.notifyAll(mp);
						
						this.squadData.modifyData(this.pList);
					
					}
					
				}else {
					System.out.println("Invalid Admin mail or password!");
				}
			
			}else {
				System.out.println("Invalid input!");
			}
		
			if(signed) {
				
				System.out.println("Welcome to your account!");
				
				while(true) {
					System.out.print("Plese enter 1 to add new player, 2 to create squad or 3 to logout: ");
					
					tempInt = sc.nextInt();
					setChoice(tempInt);
					
					if(getChoice() == 1) {
						
						playerObj = new playerInfo();
						
						System.out.print("Please enter your player name: ");
						tempString = sc.next();
						playerObj.setpName(tempString);
						
						System.out.print("Please enter player's Nationality: ");
						tempString = sc.next();
						playerObj.setNationality(tempString);
						
						System.out.print("Player's position, Please enter 1,2,3 or 4 for GoalKeaper,Defender,Midfield or Forward respectivley: ");
						tempInt = sc.nextInt();
						
						if(tempInt == 1) {
							playerObj.setPosition("GoalKeaper");
						}else if (tempInt == 2) {
							playerObj.setPosition("Defender");
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
						
						playerObj.setPoints(0);
						
						addPlayer(playerObj);
						
					}else if(getChoice() == 2) {
						
						userInter.createSquad(this.pList , this.getCurUserMail());
						
					}else if(getChoice() == 3) {
						
						break;
						
					}else {
						System.out.println("Invalid input!");
					}
					
				}
				signed = !signed;
				setCurUserMail("");
			}
		
		}
		
	}
	
	public void addUser(userInfo obj) {
		
		if(!userData.find(this.pList , obj.getMail() , obj.getPassword())) {
			
			this.pList.userList.add(obj);
			
			userData.modifyData(this.pList);
			
			System.out.println("Registration is done!");
		}else {
			System.out.println("This user already exists!");
		}
		
	}
	
	
	public void addPlayer(playerInfo playerObj) {
		
		if(!playerData.find(this.pList , playerObj.getpName() , playerObj.getNationality())) {
			this.pList.playerList.add(playerObj);
			playerData.modifyData(this.pList);
			
			System.out.println("Player added Successfully!");
			
		}else {
			System.out.println("Player already exists!");
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public void notifyAll(Map<String , Integer> mp) {
		for(Map.Entry e : mp.entrySet()) {
			
			for(squadInfo squObj : this.pList.squadList) {
				
				for(playerInfo playerObj: squObj.sPlayerList) {
					if(playerObj.getpName().equals(e.getKey())) {
						playerObj.setPoints(playerObj.getPoints() + (int)e.getValue());
					}
				}
				
			}
			
		}
	}
		
}

