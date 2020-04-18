package tetris.proj.model;

public class Person {

	String id;
	String password;
	long bestScore;
	int rank;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getBestScore() {
		return bestScore;
	}

	public void setBestScore(long bestScore) {
		this.bestScore = bestScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
