package lotto;

class PurchaseLotto {
	Lotto userLotto;
	int correctNumberCount;
	int winningGrade;

	public PurchaseLotto(Lotto newLotto) {
		this.userLotto = newLotto;
		this.correctNumberCount = 0;
		this.winningGrade = 0;
	}

	public Lotto getPurchasedLotto() {
		return this.userLotto;
	}

	public int getCorrectNumberCount() {
		return this.correctNumberCount;
	}

	public void setCorrectNumberCount(int correctNumberCount) {
		this.correctNumberCount = correctNumberCount;
	}

	public int getWinningGrade() {
		return this.winningGrade;
	}

	public void setWinningGrade(int winningGrade) {
		this.winningGrade = winningGrade;
	}
}

public class Application {
	public static void main(String[] args) {
		
	}
}
