package lotto.service;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;
import lotto.view.OutputView;

public class LottoStatisticsService {
	private final LottoResultCalculator lottoResultCalculator;
	private final OutputView outputView;

	public LottoStatisticsService(LottoResultCalculator lottoResultCalculator, OutputView outputView) {
		this.lottoResultCalculator = lottoResultCalculator;
		this.outputView = outputView;
	}

	public void summarizeStatistics(int purchaseAmount, List<Lotto> lottos, WinningNumber winningNumber) {
		Map<Prize, Integer> prizeCounts = lottoResultCalculator.calculateResults(lottos, winningNumber);
		outputView.printPrizeStatistics(prizeCounts);

		long totalEarnings = calculateTotalEarnings(prizeCounts);
		double totalYield = calculateTotalYield(purchaseAmount, totalEarnings);
		outputView.printTotalYield(totalYield);
	}

	private long calculateTotalEarnings(Map<Prize, Integer> prizeCounts) {
		return prizeCounts.entrySet().stream()
			.mapToLong(entry -> (long)entry.getKey().getPrizeAmount() * entry.getValue())
			.sum();
	}

	private double calculateTotalYield(int purchaseAmount, long totalEarnings) {
		return (double)totalEarnings / purchaseAmount * 100;
	}
}
