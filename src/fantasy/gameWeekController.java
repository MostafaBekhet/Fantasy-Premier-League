package fantasy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class gameWeekController implements DataController {
	private FileWriter writer;
	private FileReader reader;
	private gameWeekInfo gWeek;
	
	public void retriveData(parentLists pl) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			reader = new FileReader("gameWeekData.txt");
			
			BufferedReader br = new BufferedReader(reader);
			String line;
			
			while((line = br.readLine()) != null) {
				
				gWeek = new gameWeekInfo();
				String[] part = line.split(" ");
				
				gWeek.setWeekNum(Integer.parseInt(part[0]));
				
				for(int i = 1; i < part.length; i += 2) {
					String userMail = part[i];
					int userSquadPoints = Integer.parseInt(part[i + 1]);
					
					gWeek.mp.put(userMail, userSquadPoints);
				}
				
				pl.gWeekList.add(gWeek);
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void modifyData(parentLists pl) {
		// TODO Auto-generated method stub
		
		try {
			writer = new FileWriter("gameWeekData.txt");
			
			String wr = "";
			
			for(gameWeekInfo weekObj : pl.gWeekList) {
				
				wr += weekObj.getWeekNum();
				
				for(Map.Entry e : weekObj.mp.entrySet()) {
					wr += " " + e.getKey();
					wr += " " + e.getValue();
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
	
	@SuppressWarnings("rawtypes")
	public void print(parentLists pl) {
		
		System.out.println("By: Game week number, SquadUserMail , SquadPoints");
		
		String wr = "";
		
		for(gameWeekInfo weekObj : pl.gWeekList) {
			
			wr += weekObj.getWeekNum();
			
			for(Map.Entry e : weekObj.mp.entrySet()) {
				wr += " " + e.getKey();
				wr += " " + e.getValue();
				wr += "\n";
			}
			
		}
			
		System.out.print(wr);
	    wr = "";
	}
}
