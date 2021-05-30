package role.base;

public class Player {
	
	private String playerName;
	private int votedScore;
	private boolean votable;
	
	public Player(String playerName) {
		setPlayerName(playerName);
		resetVotedScore();
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getVotedScore() {
		return votedScore;
	}
	public void setVotedScore(int votedScore) {
		this.votedScore = votedScore;
	}
	
	public void resetVotedScore() {
		setVotable(true);
		setVotedScore(0);
	}
	
	public void vote(Player targetPlayer) {
		if(this.votable) {
			targetPlayer.setVotedScore(targetPlayer.getVotedScore() + 1);
		}
		else {
			System.out.println(this.playerName + " can't vote this round.");
		}
	}
	public boolean isVotable() {
		return votable;
	}
	public void setVotable(boolean votable) {
		this.votable = votable;
	}
	
	
}
