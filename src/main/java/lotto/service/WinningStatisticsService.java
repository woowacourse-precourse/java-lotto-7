package lotto.service;

import lotto.model.Lotto;
import lotto.constant.Rank;
import lotto.domain.WinningLotto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningStatisticsService {
    private static WinningStatisticsService instance;
    private WinningStatisticsService() {
    }
    public static WinningStatisticsService getInstance(){
        if(instance == null){
            instance = new WinningStatisticsService();
        }
        return instance;
    }
    public int countMatches(Lotto purchasedLotto, WinningLotto winningLotto){
        int matchCount = 0;
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.getNumbers());
        for(int number: purchasedLotto.getNumbers()){
            if(winningNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusMatched(Lotto purchasedLotto, WinningLotto winningLotto){
        return purchasedLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public  Map<Rank, Integer> collectWinningStatistics(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
//        Map<Rank, Integer> statistics = new HashMap<>();
//        for(Lotto lotto : purchasedLottos){
//            int matchCount = countMatches(lotto, winningLotto);
//            boolean isBonusMatched = isBonusMatched(lotto, winningLotto);
//            Rank rank = Rank.getRank(matchCount, isBonusMatched);
//            int rankCount = statistics.getOrDefault(rank, 0);
//            statistics.put(rank, rankCount + 1);
//        }
//        return statistics;

        return purchasedLottos.stream()
                .map(lotto -> Rank.getRank(
                        countMatches(lotto, winningLotto),
                        isBonusMatched(lotto, winningLotto)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(rank -> 1)
                ));
    }
}
