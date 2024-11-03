package lotto;

import java.util.List;

public class WinningOutput {

	private long totalAmount;
	private int amount;
	private int[] winningCounts = new int[Winning.values().length];

	public WinningOutput(int amount) {
		this.amount = amount;
		System.out.println();
		System.out.println("당첨통계");
		System.out.println("---");
	}

	public void winningOutput(List<List<Integer>> randoms, List<Integer> winningList, int bonus) {
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
		if (matchCount == 6)
			return Winning.FIRST;
		if (matchCount == 5 && matchBonus)
			return Winning.SECOND;
		if (matchCount == 5)
			return Winning.THIRD;
		if (matchCount == 4)
			return Winning.FOURTH;
		if (matchCount == 3)
			return Winning.FIFTH;
		return Winning.NONE;
	}

	private void recordWinning(int matchCount, boolean matchBonus) {
		Winning winning = determineWinning(matchCount, matchBonus);
		winningCounts[winning.getIndex()]++;
		totalAmount += winning.getWinningAmount();
	}

	public void winningPrint() {
		for (Winning w : Winning.values()) {
			System.out.println(w.getMessage() + winningCounts[w.getIndex()] + "개");
		}
		System.out.println("총 수익률은 " + rateOfReturn() + "%입니다.");
	}

	private String rateOfReturn() {
		double re = (double) totalAmount / amount;
		return String.format("%.1f", re * 100);
	}
}
