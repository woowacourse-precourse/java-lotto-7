package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;

public class WinningNumberService {
    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;


    public WinningNumberService(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = createWinningNumber(winningNumber, bonusNumber);
    }

    private WinningNumber createWinningNumber(List<Integer> winningNumber, int bonusNumber) {
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

            rankingResult.replace(rank, rankingResult.get(rank) + 1);
        }

        return rankingResult;
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
