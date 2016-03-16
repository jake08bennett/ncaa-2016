import java.io.File;
import java.util.*;

public class ReadFile {
	
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<Team> teams = new ArrayList<Team>();
		
		try {
			Scanner input = new Scanner(System.in);
			
			File file = new File("ncaa_data_2016.csv");  
			
			Scanner scanner = input = new Scanner(file);
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				data.add(line);
			 }
			
			for (int i = 1; i < 65; i++ ) {
				String meep = (data.get(i));
				String[] help = meep.split(",");
				for (int j = 0; j < 1; j++) {
					Team team = new Team(help[0],Double.parseDouble(help[1]), help[2], Integer.parseInt(help[3]));
					teams.add(team);
					
				  }
			   }
			 input.close();
			
			}  catch (Exception ex) {
			ex.printStackTrace();
			  }
 
		getFinalChamp(teams);
     
	}
	
	public static Team getWinner(Team team1, Team team2) {
		Random r =  new Random();
		double random = r.nextDouble();
		if ( random <= probability(team1, team2)) {
			return team1;
		}
		else {
			return team2;
		}
	}
	
	public static double probability(Team team1, Team team2) {
		double probability = 0;
		probability = (team1.getExpected() - (team1.getExpected() * team2.getExpected()))/ (team1.getExpected() + team2.getExpected() - 2* team1.getExpected() * team2.getExpected());
		return probability;
	}
	
	public static ArrayList<Team> sortTeam(ArrayList<Team> team, String region) {
		ArrayList<Team> newTeam = new ArrayList<Team>();
		for (Team x : team) {
			if (x.getRegion().equals(region)) {
				newTeam.add(x);
			}
		}
	 return newTeam;
	}
	

	
	public static Team getRegionWinner(ArrayList<Team> team) {
	    Team first = getWinner(team.get(0), team.get(15));
	    Team second = getWinner(team.get(1), team.get(14));
	    Team third = getWinner(team.get(2), team.get(13));
	    Team fourth = getWinner(team.get(3), team.get(12));
	    Team fifth = getWinner(team.get(4), team.get(11));
	    Team sixth = getWinner(team.get(5), team.get(10));
	    Team seventh = getWinner(team.get(6), team.get(9));
	    Team eight = getWinner(team.get(7), team.get(8));
	    Team firstsecond = getWinner(first, second);
	    Team threefourth = getWinner(third, fourth);
	    Team fivesix = getWinner(fifth, sixth);
	    Team seveneight = getWinner(seventh, eight);
	    return getWinner( getWinner(firstsecond, threefourth), getWinner(fivesix, seveneight));
	  	
	}
	public static void getFinalChamp(ArrayList<Team> teams) {
		ArrayList<Team> west = sortTeam(teams, "West");
		ArrayList<Team> midwest = sortTeam(teams, "Midwest");
		ArrayList<Team> east = sortTeam(teams, "East");
		ArrayList<Team> south = sortTeam(teams, "South");
	    System.out.println(getRegionWinner(west).getName() + " has won the West tournament");
	    System.out.println(getRegionWinner(midwest).getName() + " has won the Midwest tournament");
	    System.out.println(getRegionWinner(east).getName() + " has won the East tournament");
	    System.out.println(getRegionWinner(south).getName() + " has won the South tournament");
	    Team final1 = getWinner(getRegionWinner(west),getRegionWinner(south));
	    Team final2 = getWinner(getRegionWinner(east),getRegionWinner(midwest));
	    System.out.println(final1.getName() + " is going to the finals!");
	    System.out.println(final2.getName() + " is going to the finals!");
	    System.out.println(getWinner(final1, final2).getName() +  " wins March Madness");
	    System.out.println();
	}
	
	
}