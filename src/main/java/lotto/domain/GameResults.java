package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lotto.domain.enums.Rank;

public class GameResults {
	private final Map<Rank, Integer> gameResultMap;

	public GameResults() {
		this.gameResultMap = new HashMap<>();
	}

	public void calculateGameResult(List<Lotto> lottos, WinningLotto winningLotto, BonusNumber bonusNumber) {
		for (Lotto lotto : lottos) {
			Optional<Rank> rank = winningLotto.calculateRank(lotto, bonusNumber);
			rank.ifPresent(value -> gameResultMap.put(rank.get(), gameResultMap.getOrDefault(rank.get(), 0) + 1));
		}
	}


	public Map<Rank, Integer> getGameResultMap() {
		return gameResultMap;
	}
}
