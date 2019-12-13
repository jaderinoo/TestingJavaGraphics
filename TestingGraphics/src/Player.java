import java.util.concurrent.ThreadLocalRandom;

public class Player {

	    int str;
		String name;

		public Player(String name, int str) {

	    	Object[] Statistics = {name, str};
	    	
	    	//Use this as a ledger for player.txt 
	    	this.name = name;
	    	this.str = str;
	   }
		
		public Object getName() {
	        return name;
	    }
		
	    public int getStr() {
	        return str;
	    }
}

