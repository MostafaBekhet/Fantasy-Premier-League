package fantasy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class parentLists {

	public ArrayList<userInfo> userList;
	public ArrayList<playerInfo> playerList;
	public ArrayList<squadInfo> squadList;
	
	public parentLists() {
		userList = new ArrayList<userInfo>();
		playerList = new ArrayList<playerInfo>();
		squadList = new ArrayList<squadInfo>();
	}
}

public class SystemController {
	private int choice;
	public boolean signed = false;
	public int tempInt;
	public String tempString;
	
	private userInterAction userInter;
	private DataController userData;
	private DataController playerData;
	private DataController squadData;
	private userInfo userObj;
	private parentLists pList;
	private Scanner sc;
	
	/////// setters
	public void setChoice(int ch) {
		this.choice = ch;
	}
	
	//// getters
	public int getChoice() {
		return this.choice;
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			System.out.print("Plese enter 1 to Login, 2 to register or 3 to exit: ");
			
			sc = new Scanner(System.in);
			tempInt = sc.nextInt();
			
			setChoice(tempInt);
			
			if(getChoice() == 1) {
				String mail , pass;
				System.out.print("Please enter your mail: ");
				mail = sc.next();
				
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
						
						userInter.addPlayer(this.pList);
						
					}else if(getChoice() == 2) {
						
						userInter.createSquad(this.pList , userObj.getMail());
						
					}else if(getChoice() == 3) {
						
						break;
						
					}else {
						System.out.println("Invalid input!");
					}
					
				}
				signed = !signed;
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
}

