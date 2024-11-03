package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.model.Lotto;
import lotto.model.LottoBonus;
import lotto.model.LottoRank;
import lotto.model.LottoTicket;
import lotto.view.OutputView;

public class LottoResultChecker {
	public void displayResults(List<LottoTicket> tickets, Lotto winningLotto, LottoBonus bonus) {
		Map<LottoRank, Integer> resultCount = checkResults(tickets, winningLotto, bonus);
		OutputView.displayResult(resultCount);

		int purchaseAmount = tickets.size() * LottoTicketGenerator.LOTTO_PRICE;
		double profitRate = calculateProfitRate(resultCount, purchaseAmount);
		OutputView.displayProfitRate(profitRate);
	}

	public Map<LottoRank, Integer> checkResults(List<LottoTicket> tickets, Lotto winningLotto, LottoBonus bonus) {
		Map<LottoRank, Integer> resultCount = new EnumMap<>(LottoRank.class);
		for (LottoRank rank : LottoRank.values()) {
			resultCount.put(rank, 0);
		}

		for (LottoTicket ticket : tickets) {
			int matchCount = countMatchingNumbers(ticket, winningLotto);
			boolean bonusMatch = ticket.getNumbers().contains(bonus.getBonusNumber());

			LottoRank rank = getRank(matchCount, bonusMatch);
			if (rank != null) {
				resultCount.put(rank, resultCount.get(rank) + 1);
			}
		}
		return resultCount;
	}

	private int countMatchingNumbers(LottoTicket ticket, Lotto winningLotto) {
		int matchCount = 0;
		for (int number : ticket.getNumbers()) {
			if(winningLotto.getNumbers().contains(number)) {
				matchCount++;
			}
		}
		return matchCount;
	}
	
	private LottoRank getRank(int matchCount, boolean bonusMatch) {
		if(matchCount == 6) return LottoRank.SIX_MATCH;
		if(matchCount == 5 && bonusMatch) return LottoRank.FIVE_MATCH_WITH_BONUS;
		if(matchCount == 5) return LottoRank.FIVE_MATCH;
		if(matchCount == 4) return LottoRank.FOUR_MATCH;
		if(matchCount == 3) return LottoRank.THREE_MATCH;
		return null;
	}
	
	public double calculateProfitRate(Map<LottoRank, Integer> resultCount, int purchaseAmount) {
		int totalPrize = 0;
		for (Map.Entry<LottoRank, Integer> entry : resultCount.entrySet()) {
			totalPrize += entry.getKey().getPrize() * entry.getValue();
		}
		double profitRate = (double) totalPrize / purchaseAmount * 100;
		
		return profitRate;
	}
}
