package lotto.service;

import lotto.model.Lotto;
import lotto.constant.Rank;
import lotto.model.WinningLotto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultStatisticsService {
    private static ResultStatisticsService instance;
    private ResultStatisticsService() {
    }
    public static ResultStatisticsService getInstance(){
        if(instance == null){
            instance = new ResultStatisticsService();
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
