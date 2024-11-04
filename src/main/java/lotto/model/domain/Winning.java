package lotto.model.domain;

import lotto.model.dto.WinningDTO;

import java.util.EnumMap;
import java.util.Map;

public class Winning {
	private final LottoBundle lottoBundle;
	private final WinningDTO winningDTO;
	private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

	public Winning(LottoBundle lottoBundle, WinningDTO winningDTO) {
		this.lottoBundle = lottoBundle;
		this.winningDTO = winningDTO;
		initializeRankCounts();
		calculateRanks();
	}

	private void initializeRankCounts() {
		for (Rank rank : Rank.values()) {
			rankCounts.put(rank, 0);
		}
	}

	private void calculateRanks() {
		lottoBundle.lottoBundle().forEach(this::updateRankCount);
	}

	private void updateRankCount(Lotto lotto) {
		int matchCount = countMatch(lotto);
		Rank rank = Rank.getRank(matchCount, isBonusMatched(lotto));
		incrementRankCount(rank);
	}

	private int countMatch(Lotto lotto) {
		return (int)lotto.getNumbers().stream()
			.filter(winningDTO.getWinningNumber()::contains)
			.count();
	}

	private boolean isBonusMatched(Lotto lotto) {
		return lotto.getNumbers().contains(winningDTO.getBonusNumber());
	}

	private void incrementRankCount(Rank rank) {
		if (rank != null) {
			rankCounts.put(rank, rankCounts.get(rank) + 1);
		}
	}

	public Map<Rank, Integer> getRankCounts() {
		return rankCounts;
	}

	public int getTotalPrize() {
		return calculateTotalPrize();
	}

	private int calculateTotalPrize() {
		return rankCounts.entrySet().stream()
			.mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();
	}
}
