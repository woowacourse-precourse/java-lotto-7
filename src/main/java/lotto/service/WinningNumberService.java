package lotto.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;

public class WinningNumberService {
    private List<Lotto> lottos;
    private WinningNumber winningNumber;


    public WinningNumberService(List<Lotto> lottos, String winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = createWinningNumber(winningNumber, bonusNumber);
    }

    private WinningNumber createWinningNumber(String winningNumbers, int bonusNumber) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumber(winningNumber, bonusNumber);
    }

    public Map<Ranking, Integer> getRankingResult() {
        Map<Ranking, Integer> rankingResult = initRankingResult();
        int matchCount;
        boolean matchBonus;

        for (Lotto lotto : lottos) {
            matchCount = getMatchCount(lotto.getNumbers(), winningNumber.getNumbers());
            matchBonus = getMatchBonus(lotto.getNumbers(), winningNumber.getBonusNumber());

            Ranking rank = getRanking(matchCount, matchBonus);

            if (rank != null) {
                rankingResult.replace(rank, rankingResult.get(rank) + 1);
            }
        }
        return rankingResult;
    }

    public double getEarningsRate(Map<Ranking, Integer> rankingResult, int amount) {
        int earnings = 0;
        double earningsRate;

        for (Entry<Ranking, Integer> ranking : rankingResult.entrySet()) {
            earnings += ranking.getKey().getPrice() * ranking.getValue();
        }

        earningsRate = (double) earnings / amount * 100;

        return Double.parseDouble(String.format("%.1f", earningsRate));
    }

    private Map<Ranking, Integer> initRankingResult() {
        Map<Ranking, Integer> rankingResult = new HashMap<>();

        for (Ranking rank : Ranking.values()) {
            rankingResult.put(rank, 0);
        }

        return rankingResult;
    }

    private int getMatchCount(List<Integer> lottoNumber, List<Integer> winningNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private boolean getMatchBonus(List<Integer> lottoNumber, int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }


    private Ranking getRanking(int matchCount, boolean matchBonus) {
        return Ranking.valueOf(matchCount, matchBonus);
    }
}
