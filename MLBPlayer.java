public class MLBPlayer {

	//player identification fields
	private String name;
	private String team;
	private String position;

	//player data fields
	private int games;
	private int atBats;
	private int runs;
	private int hits;
	private int doubles;
	private int triples;
	private int homeRuns;
	private int runsBattedIn;
	private int walks;
	private int hitByPitch;
	private int sacFly;
	private int strikeOuts;
	private int stolenBases;
	private int caughtStealing;

	//purpose: 	default constructor, initializes String fields to empty strings
	//			and integer fields to 0
	//input: 	none
	//output: 	none
	public MLBPlayer () {
		name = "";
		team = "";
		position = "";

		games = 0;
		atBats = 0;
		runs = 0;
		hits = 0;
		doubles = 0;
		triples = 0;
		homeRuns = 0;
		runsBattedIn = 0;
		walks = 0;
		hitByPitch = 0;
		sacFly = 0;
		strikeOuts = 0;
		stolenBases = 0;
		caughtStealing = 0;
	}

	//purpose: 	Constructs a player object with a name, team and position
	//			and initializes player data integer fields to 0
	//input: 	Strings values of the players name, team and position
	//output: 	none
	public MLBPlayer ( String name, String team, String position ){
		this.name = name;
		this.team = team;
		this.position = position;

		games = 0;
		atBats = 0;
		runs = 0;
		hits = 0;
		doubles = 0;
		triples = 0;
		homeRuns = 0;
		runsBattedIn = 0;
		walks = 0;
		hitByPitch = 0;
		sacFly = 0;
		strikeOuts = 0;
		stolenBases = 0;
		caughtStealing = 0;
	}

	//purpose: 	Constructs a player object with a name, team and position
	//			and initializes player data integer fields with existing data
	//input: 	String values of the players name, team and position and
	//			int value for the player's current numbers: games, atBats, runs,
	//			hits, doubles, triples, homeRuns, runsBattedIn, walks,
	//			hitByPitch, strikeOuts, stolenBases, caughtStealing
	//output: 	none
	public MLBPlayer ( String name, String team, String position, int games,
			int atBats, int runs, int hits, int doubles, int triples,
			int homeRuns, int runsBattedIn, int walks, int hitByPitch,
			int sacFly, int strikeOuts, int stolenBases, int caughtStealing){

		this.name = name;
		this.team = team;
		this.position = position;

		this.games = games;
		this.atBats = atBats;
		this.runs = runs;
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.homeRuns = homeRuns;
		this.runsBattedIn = runsBattedIn;
		this.walks = walks;
		this.hitByPitch = hitByPitch;
		this.sacFly = sacFly;
		this.strikeOuts = strikeOuts;
		this.stolenBases = stolenBases;
		this.caughtStealing = caughtStealing;
	}

	/************** ACCESSOR AND MUTATOR METHODS **************/
	//purpose:  	gets the players name
	//input: 	none
	//output:  	the players name
	public String getName () {
		return this.name;
	}

	//purpose:  	sets the players name
	//input: 	the name as a String
	//output:  	none
	public void setName (String name) {
		this.name = name;
	}

	//purpose:  	gets the players team
	//input: 	none
	//output:  	the players team
	public String getTeam () {
		return this.team;
	}

	//purpose:  	sets the players team
	//input: 	the team as a String
	//output:  	the players team is changed
	public void setTeam (String team) {
		this.team = team;
	}

	//purpose:  	gets the players position
	//input: 	none
	//output:  	the players position
	public String getPosition () {
		return this.position;
	}

	//purpose:  	gets the players position
	//input: 	the position as a String
	//output:  	the players postion is changed
	public void setPosition (String position) {
		this.position = position;
	}


	//purpose:  	gets the number of games played
	//input: 	none
	//output:  	the number of games played
	public int getGames() {
		return this.games;
	}

	//purpose:  	sets the number of games played
	//input: 	number of games played
	//output:  	this.games is changed
	public void setGames (int games) {
		this.games = games;
	}

	//purpose:  	gets the number of at bats
	//input: 	none
	//output:  	the number of at bats
	public int getAtBats() {
		return this.atBats;
	}

	//purpose:  	sets the number of at bats
	//input: 	number of at bats
	//output:  	this.atBats is changed
	public void setAtBats (int atBats) {
		this.atBats = atBats;
	}

	//purpose:  	gets the number of runs
	//input: 	none
	//output:  	the number of runs
	public int getRuns() {
		return this.runs;
	}

	//purpose:  	sets the number of runs
	//input: 	number of runs
	//output:  	this.runs is changed
	public void setRuns (int runs) {
		this.runs = runs;
	}

	//purpose:  	gets the number of hits
	//input: 	none
	//output:  	the number of hits is changed
	public int getHits() {
		return this.hits;
	}

	//purpose:  	sets the number of hits
	//input: 	number of hits
	//output:  	this.hits is changed
	public void setHits (int hits) {
		this.hits = hits;
	}

	//purpose:  	gets the number of double hits
	//input: 	none
	//output:  	the number of double hits
	public int getDoubles() {
		return this.doubles;
	}

	//purpose:  	sets the number of double hits
	//input: 	number of doubles
	//output:  	this.doubles is changed
	public void setDoubles (int doubles) {
		this.doubles = doubles;
	}

	//purpose:  	gets the number of triples
	//input: 	none
	//output:  	the number of triples
	public int getTriples() {
		return this.triples;
	}

	//purpose:  	sets the number of triples
	//input: 	number of triples
	//output:  	this.triples is changed
	public void setTriples (int triples) {
		this.triples = triples;
	}

	//purpose:  	gets the number of home runs
	//input: 	none
	//output:  	the number of home runs
	public int getHomeRuns() {
		return this.homeRuns;
	}

	//purpose:  	sets the number of home runs
	//input: 	number of home runs
	//output:  	this.homeRuns is changed
	public void setHomeRuns (int homeRuns) {
		this.homeRuns = homeRuns;
	}

	//purpose:  	gets the number of runs batted in
	//input: 	none
	//output:  	the number of runs batted in
	public int getRunsBattedIn() {
		return this.runsBattedIn;
	}

	//purpose:  	sets the number of runs batted in
	//input: 	number of runs batted in
	//output:  	this.runsBattedIn is changed
	public void setRunsBattedIn (int runsBattedIn) {
		this.runsBattedIn = runsBattedIn;
	}

	//purpose:  	gets the number of walks
	//input: 	none
	//output:  	the number of walks
	public int getWalks() {
		return this.walks;
	}

	//purpose:  	sets the number of walks
	//input: 	number of walks
	//output:  	this.walks is changed
	public void setWalks(int walks) {
		this.walks = walks;
	}

	//purpose:  	gets the number of times hit by a pitch
	//input: 	none
	//output:  	the number of times hit by a pitch
	public int getHitByPitch() {
		return this.hitByPitch;
	}

	//purpose:  	sets the number of times hit by a pitch
	//input: 	number of times hit by a pitch
	//output:  	this.hitByPitch is changed
	public void setHitByPitch(int hitByPitch) {
		this.hitByPitch = hitByPitch;
	}

	//purpose:  	gets the number of sacrifices flies
	//input: 	none
	//output:  	the number of sacrifices flies
	public int getSacrifices() {
		return this.sacFly;
	}

	//purpose:  	sets the number of sacrifices flies
	//input: 	number of sacrifice flies
	//output:  	this.sacFly is changed
	public void setSacrifices(int sacFly) {
		this.sacFly = sacFly;
	}

	//purpose:  	gets the number of strike outs
	//input: 	none
	//output:  	the number of strike outs
	public int getStrikeOuts() {
		return this.strikeOuts;
	}

	//purpose:  	sets the number of strike outs
	//input: 	number of strike outs
	//output:  	this.strikeOuts is changed
	public void setStrikeOuts (int strikeOuts) {
		this.strikeOuts = strikeOuts;
	}

	//purpose:  	gets the number of stolen bases
	//input: 	none
	//output:  	the number of stolen bases
	public int getStolenBases() {
		return this.stolenBases;
	}

	//purpose:  	sets the number of stolen bases
	//input: 	number of stolen bases
	//output:  	this.stolenBases is changed
	public void setStolenBases (int stolenBases) {
		this.stolenBases = stolenBases;
	}

	//purpose:  	gets the number of times caught stealing
	//input: 	none
	//output:  	the number of times caught stealing
	public int getCaughtStealing() {
		return this.caughtStealing;
	}

	//purpose:  	sets the number of times caught stealing
	//input: 	number of times caught stealing
	//output:  	this.caughtStealing is changed
	public void setCaughtStealing (int caughtStealing) {
		this.caughtStealing = caughtStealing;
	}

	/******************* INSTANCE METHODS *******************/

	//purpose:  	calculate the batting average
	//input: 	uses players number of at bats and number of hits
	//output:  	the players batting average (double)
	public double calcBattingAvg () {
		return ((double)this.atBats / this.hits);
	}

	//purpose:  	calculate the on base percentage (H+BB+HBP)/(AB+BB+HBP+SF)
	//input: 	uses players number of at bats and number of hits
	//output:  	the players on base percentage (double)
	public double calcOnBasePercentage() {
		return (double)(this.hits + this.walks + this.hitByPitch)/
				(this.atBats + this.walks + this.hitByPitch + this.sacFly);
	}

	//purpose:  	calculate the on percentage of 'big' base hits
	//input: 	uses players total bases and number of at bats
	//output:  	the players slugging percentage (double)
	public double calcSluggingPercentage() {
		return ((double)this.calcTotalBases() / this.atBats);
	}

	//purpose:  	calculate the total number single hits
	//input: 	uses players hits, doubles, triples and home runs
	//output:  	the players total single hits (int)
	public int calcSingles() {
		return (this.hits - (this.doubles + this.triples + this.homeRuns));
	}

	//purpose:  	calculate the total number of bases
	//input: 	uses players singles, doubles, triples and home runs
	//output:  	the players total bases (int)
	public int calcTotalBases() {
		return (1 * this.calcSingles() + 2 * this.doubles +
				3 * this.triples + 4 * this.homeRuns);
	}

	//purpose:  	calculate the combined on base and slugging percentage
	//input: 	uses players on base percentage and slugging percentage
	//output:  	the player's combined on base and slugging percentage  (double)
	public double calcOnBasePlusSlugging() {
		return this.calcOnBasePercentage() + this.calcSluggingPercentage();
	}

	//purpose:  	calculate the run's created by the player = (OBP*SLG*AB).
	//	There are many variations on the formula to calculate this stat.
	//	The simplest form is used here.
	//input: 	uses players on base percentage, slugging percentage and at bats
	//output:  	the number of runs created by the player  (double)
	public double calcRunsCreated() {
		return (this.calcOnBasePercentage() * this.calcSluggingPercentage()
				* this.atBats);
	}
}
