package lotto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public class MatchCount {
    private MatchCount(){}

    public static List<Integer> calculateMatchCounts(Set<Integer> winningNumbers, List<Lotto> lottos, Integer bonusnum) {
        List<Integer> matchCounts = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Set<Integer> originalNumbers = new HashSet<>(lotto.getNumbers()); // 원본 복사
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
            lottoNumbers.retainAll(winningNumbers);
            if (lottoNumbers.size() == 5) {
                if (originalNumbers.contains(bonusnum)) {
                    lotto.isBonus();
                }
            }
            matchCounts.add(lottoNumbers.size());
        }

        return matchCounts;
    }
}
