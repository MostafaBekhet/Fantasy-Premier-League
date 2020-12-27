package fantasy;

import java.io.IOException;

public interface DataController {
	
	public default void retriveData(parentLists pl) throws IOException {
		
	}
	
	public default void modifyData(parentLists pl) {
		
	}
	
	public default void print(parentLists pl) {
		
	}
	
	public default Object getMamber(parentLists pl , String n) {
		return null;
	}
	
	public default boolean find(parentLists pl , String mail , String pass) { 
		return false;
	}
}








