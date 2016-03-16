
public class Team {
	private String name;
	private int seed;
	private double expected;
	private String region;
	
	public Team(String name, double expected, String region, int seed) {
		this.seed = seed;
		this.region = region;
		this.expected = expected/100;
		this.name = name;
	}
	
	public String toString() {
		return (name + " " + seed + " " + region + " " +  expected);
	}
	
	public  double getExpected() {
		return expected;
	}
	
	public int getSeed() {
		return seed;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public void setSeed(int newseed) {
		seed = newseed;
	}

}