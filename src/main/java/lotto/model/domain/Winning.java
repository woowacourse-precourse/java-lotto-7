package lotto.model.domain;

import lotto.model.dto.WinningDTO;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Winning {
	private final LottoBundle lottoBundle;
	private final WinningDTO winningDTO;
	private Map<Rank, Integer> rankCounts;

	public Winning(LottoBundle lottoBundle, WinningDTO winningDTO) {
		this.lottoBundle = lottoBundle;
		this.winningDTO = winningDTO;
		rankCounts = new EnumMap<>(Rank.class);
		getWinningResult();
	}

	private void getWinningResult() {
		initializeRankCounts();
		calculateRanks();
	}

	private void initializeRankCounts() {
		rankCounts = Arrays.stream(Rank.values())
			.collect(Collectors.toMap(rank -> rank, rank -> 0));
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
