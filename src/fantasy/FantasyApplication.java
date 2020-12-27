package fantasy;


public class FantasyApplication {
	private static SystemController contObject;
	public static void main(String [] args) {
		contObject = new SystemController();
		contObject.run();
	}
}