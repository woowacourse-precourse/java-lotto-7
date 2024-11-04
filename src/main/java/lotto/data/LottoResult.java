package lotto.data;

import java.text.MessageFormat;

public class LottoResult {
	private int first;
	private int second;
	private int third;
	private int fourth;
	private int fifth;

	public void addResult(int winningNumbersCount, boolean hasBonusNumber) {
		if (winningNumbersCount == 6) {
			first++;
		}
		if (winningNumbersCount == 5) {
			winningNumbersCountIsFive(hasBonusNumber);
		}
		if (winningNumbersCount == 4) {
			fourth++;
		}
		if (winningNumbersCount == 3) {
			fifth++;
		}
	}

	private void winningNumbersCountIsFive(boolean hasBonusNumber) {
		if (hasBonusNumber) {
			second++;
			return;
		}
		third++;
	}

	public String print(int amount) {
		return MessageFormat.format(
			"""
				당첨 통계
				---
				3개 일치 (5,000원) - {0}개
				4개 일치 (50,000원) - {1}개
				5개 일치 (1,500,000원) - {2}개
				5개 일치, 보너스 볼 일치 (30,000,000원) - {3}개
				6개 일치 (2,000,000,000원) - {4}개
				총 수익률은 {5}%입니다.
				""", fifth, fourth, third, second, first, reteOfReturn(amount)
		);
	}

	private String reteOfReturn(int amount) {
		double profit = 0.0D;
		profit += first * 2_000_000_000;
		profit += second * 30_000_000;
		profit += third * 1_500_000;
		profit += fourth * 50_000;
		profit += fifth * 5_000;
		return String.format("%.1f", (profit / amount) * 100);
	}
}
