package lotto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public class MatchCount {
    private MatchCount(){}

    public static List<Integer> calculateMatchCounts(Set<Integer> winningNumbers, List<Lotto> lottos) {
        List<Integer> matchCounts = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
            lottoNumbers.retainAll(winningNumbers);
            matchCounts.add(lottoNumbers.size());
        }

        return matchCounts;
    }
}
