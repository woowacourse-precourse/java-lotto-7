package lotto;

import java.util.List;

public class WinningOutput {

	private int totalAmount;
	private int amount;
	private int[] winningCounts = new int[Winning.values().length];

	public void winningOutput() {
		System.out.println();
		System.out.println("당첨통계");
		System.out.println("---");
	}

	public void winningOutput(int amount, List<List<Integer>> randoms, List<Integer> winningList, int bonus) {
		this.amount = amount;
		for (List<Integer> randomNumbers : randoms) {
			int matchCount = winningCheck(randomNumbers, winningList);
			boolean matchBonus = randomNumbers.contains(bonus);
			recordWinning(matchCount, matchBonus);
		}
	}

	private int winningCheck(List<Integer> randomNumbers, List<Integer> winningList) {
		return (int) randomNumbers.stream().filter(winningList::contains).count();
	}

	private Winning determineWinning(int matchCount, boolean matchBonus) {
		if (matchCount == 6) {
			return Winning.FIRST;
		}
		if (matchCount == 5 && matchBonus) {
			return Winning.SECOND;
		}
		if (matchCount == 5) {
			return Winning.THIRD;
		}
		if (matchCount == 4) {
			return Winning.FOURTH;
		}
		if (matchCount == 3) {
			return Winning.FIFTH;
		}
		return Winning.NONE;
	}

	private void recordWinning(int matchCount, boolean matchBonus) {
		Winning winning = determineWinning(matchCount, matchBonus);
		winningCounts[winning.ordinal()]++;
		totalAmount += winning.getWinningAmount();
	}

}
