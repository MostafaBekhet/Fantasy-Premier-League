package fantasy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class userDataController implements DataController {
	
	public FileWriter writer;
	public FileReader reader;
	public userInfo userObj;

	@Override
	public void retriveData(parentLists pl) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			reader = new FileReader("userData.txt");
			
			BufferedReader br = new BufferedReader(reader);
			String line;
			
			while((line = br.readLine()) != null) {
				
				userObj = new userInfo();
				
				String[] part = line.split(" ");
				userObj.setName(part[0]);
				userObj.setMail(part[1]);
				userObj.setPassword(part[2]);
				userObj.setTeamName(part[3]);
				
				if(!find(pl , userObj.getMail() , userObj.getPassword())) {
					pl.userList.add(userObj);
				}
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifyData(parentLists pl) {
		// TODO Auto-generated method stub
		
		try {
			writer = new FileWriter("userData.txt");
			
			String wr = "";
			
			for (userInfo x : pl.userList) { 
				
				wr += x.getName();
				wr += " " + x.getMail();
				wr += " " + x.getPassword();
				wr += " " + x.getTeamName();
	            	            	            
	            writer.write(wr + "\n");
	            wr = "";
	        }
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void print(parentLists pl) {
		
		System.out.println("By: userName , userMail , userPassword , userTeamName..");
		
		for (userInfo x : pl.userList) { 
			
			System.out.println(x.getName() + " " + x.getMail() + " " + x.getPassword() + " " + x.getTeamName());
			
        }
	}
	
	public userInfo getMamber(parentLists pl , String mail) {
		
		for(userInfo x : pl.userList) {
			
			if(((userInfo) x).getMail().equals(mail)) {
				return x;
			}
			
		}
		
		return null;
	}
	
	public boolean find(parentLists pl , String mail , String pass) {
		for(userInfo x : pl.userList) {
			
			if(((userInfo) x).getMail().equals(mail) && ((userInfo) x).getPassword().equals(pass)) {
				return true;
			}
			
		}
		
		return false;
	}

}
