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
		
		public String getName() {
	        return name;
	    }
		
		public void setName(String tempName) {
	        this.name = tempName;
	    }
		
	    public int getStr() {
	        return str;
	    }
}

