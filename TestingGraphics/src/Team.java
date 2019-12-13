
public class Team {

	Player player;

	public Team(Player player) {

    	Object[] Statistics = {player};
    	
    	//Use this as a ledger for player.txt 
    	this.player = player;
   }
	
	public Object getTeam() {
        return player;
    }

}
