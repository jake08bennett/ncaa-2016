public class Team {
	private String name;
	private int seed;
	private double expected;
	private String region;
	public Team(String name, double expected, String region, int seed) {
		this.seed = seed;
		this.region = region;
		this.expected = expected;
		this.name = name;
	}
	public String toString() {
		return (name + " " + seed + " " + region + " " +  expected);
	}

}