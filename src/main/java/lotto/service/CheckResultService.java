package lotto.service;

import lotto.Lotto;
import lotto.constant.Prize;
import lotto.model.MatchResult;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckResultService {
    public MatchResult checkMatchCount(Lotto purchasedLotto, Lotto winningLotto, int bonusNumber){
        int matchCount = 0;
        Set<Integer> setForCheck = new HashSet<>(winningLotto.getNumbers());
        for(int number: purchasedLotto.getNumbers()){
            if(setForCheck.contains(number)){
                matchCount++;
            }
        }
        return new MatchResult(matchCount, setForCheck.contains(bonusNumber));
    }


    public  Map<Prize, Integer> collectWinningStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        return purchasedLottos.stream()
                .map(lotto -> Prize.getRank(checkMatchCount(lotto, winningLotto, bonusNumber)))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(prize -> 1)
                ));
    }
}
