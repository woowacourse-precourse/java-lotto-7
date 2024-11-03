package lotto.service;

import lotto.component.Lotto;
import lotto.component.Prize;
import lotto.component.LottoMatchCounts;
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
    public LottoMatchCounts countMatches(Lotto purchasedLotto, WinningLotto winningLotto){
        int matchCount = 0;
        boolean isBonusMatched = false;
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.getLotto().getNumbers());
        for(int number: purchasedLotto.getNumbers()){
            if(winningNumbers.contains(number)){
                matchCount++;
            }
            if(winningLotto.getBonusNumber() == number){
                isBonusMatched = true;
            }
        }
        return new LottoMatchCounts(matchCount, isBonusMatched);
    }


    public  Map<Prize, Integer> collectWinningStatistics(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return purchasedLottos.stream()
                .map(lotto -> Prize.getRank(countMatches(lotto, winningLotto)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(prize -> 1)
                ));
    }
}
