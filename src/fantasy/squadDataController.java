package fantasy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class squadDataController implements DataController {
	public FileWriter writer;
	public FileReader reader;
	public playerInfo playerObj;
	public squadInfo squadObj;
	
	public void retriveData(parentLists pl) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			reader = new FileReader("squadData.txt");
			
			BufferedReader br = new BufferedReader(reader);
			String line;
			
			while((line = br.readLine()) != null) {
				squadObj = new squadInfo();
				
				String[] part = line.split(" ");
				
				squadObj.setSquadUserMail(part[0]);
				
				for(int i = 1; i < part.length; i += 6) {
					playerObj = new playerInfo();
					playerObj.setpName(part[i]);
					playerObj.setNationality(part[i + 1]);
					playerObj.setPosition(part[i + 2]);
					playerObj.setClub(part[i + 3]);
					playerObj.setPrice(Integer.parseInt(part[i + 4]));
					playerObj.setPoints(Integer.parseInt(part[i + 5]));
					
					squadObj.sPlayerList.add(playerObj);
				}
				
				pl.squadList.add(squadObj);
				
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
			writer = new FileWriter("squadData.txt");
			
			String wr = "";
			
			for (squadInfo x : pl.squadList) { 
				
				int temp = 0;
				wr += x.getSquadUserMail();
				wr += " ";
				
				for(playerInfo p : x.sPlayerList) {
					++temp;
					wr += p.getpName();
					wr += " " + p.getNationality();
					wr += " " + p.getPosition();
					wr += " " + p.getClub();
					wr += " " + p.getPrice();
					wr += " " + p.getPoints();
					if(temp < x.sPlayerList.size()) {
						wr += " ";
					}
				}
				
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
		
		System.out.println("By: squadUserMail, playerName , playerNationality , playerPosition , playerClub , playerPrice , playerPoints");
		
		String wr = "";
		
		for (squadInfo x : pl.squadList) { 

			wr += x.getSquadUserMail() + "\n";
			
			for(playerInfo p : x.sPlayerList) {
				wr += p.getpName();
				wr += " " + p.getNationality();
				wr += " " + p.getPosition();
				wr += " " + p.getClub();
				wr += " " + p.getPrice();
				wr += " " + p.getPoints();
				wr += "\n";
			}
			
			System.out.print(wr);
	        wr = "";
		}
	}
	
	public squadInfo getMamber(parentLists pl , String squadUserMail) {
		
		for(squadInfo x : pl.squadList) {
			
			if(((squadInfo) x).getSquadUserMail().equals(squadUserMail)) {
				return x;
			}
			
		}
		
		return null;
	}
	
	public boolean find(parentLists pl , String squadUserMail , String nation) {
		for(squadInfo x : pl.squadList) {
			
			if(((squadInfo) x).getSquadUserMail().equals(squadUserMail)) {
				return true;
			}
			
		}
		
		return false;
	}
}
