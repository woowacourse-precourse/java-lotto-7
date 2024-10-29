package lotto;

public class WinningNumber {

	private String winning;

	public WinningNumber(String winning) {
		this.winning = winning;
	}

	public void winningCheck() {
		String[] winningArr = winningSplit();
	}

	private String[] winningSplit() {
		return winning.split(",");
	}
}
