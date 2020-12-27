package fantasy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class playerDataController implements DataController {
	public FileReader reader;
	public playerInfo playerObj;
	
	public void retriveData(parentLists pl) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			reader = new FileReader("playerData.txt");
			
			BufferedReader br = new BufferedReader(reader);
			String line;
			
			while((line = br.readLine()) != null) {
				
				playerObj = new playerInfo();
				
				String[] part = line.split(" ");
				playerObj.setpName(part[0]);
				playerObj.setNationality(part[1]);
				playerObj.setPosition(part[2]);
				playerObj.setClub(part[3]);
				playerObj.setPrice(Integer.parseInt(part[4]));
				
				if(!find(pl , playerObj.getpName() , playerObj.getNationality())) {
					pl.playerList.add(playerObj);
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
			FileWriter writer = new FileWriter("playerData.txt");
			
			String wr = "";
			
			for (playerInfo x : pl.playerList) { 
				
				wr += x.getpName();
				wr += " " + x.getNationality();
				wr += " " + x.getPosition();
				wr += " " + x.getClub();
				wr += " " + x.getPrice();
	            	            	            
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
		
		System.out.println("By: playerName , playerNationality , playerPosition , playerClub , playerPrice");
		
		for (playerInfo x : pl.playerList) { 
			
			System.out.println(x.getpName() + " " + x.getNationality() + " " + x.getPosition() + " " + 
								x.getClub() + " " + x.getPrice());
			
        }
	}
	
	public playerInfo getMamber(parentLists pl , String name) {
		
		for(playerInfo x : pl.playerList) {
			
			if(((playerInfo) x).getpName().equals(name)) {
				return x;
			}
			
		}
		
		return null;
	}
	
	public boolean find(parentLists pl , String name , String nation) {
		for(playerInfo x : pl.playerList) {
			
			if(((playerInfo) x).getpName().equals(name) && ((playerInfo) x).getNationality().equals(nation)) {
				return true;
			}
			
		}
		
		return false;
	}
	
}
