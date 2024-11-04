package lotto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;

public class MatchCount {
    private MatchCount() {}

    public static List<Integer> calculateMatchCounts(Set<Integer> winningNumbers, List<Lotto> lottos) {
        List<Integer> matchCounts = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
            lottoNumbers.retainAll(winningNumbers);
            matchCounts.add(lottoNumbers.size());
        }

        return matchCounts;
    }

    public static List<Integer> calculateBonusCounts(Set<Integer> winningNumbers, List<Lotto> lottos, Integer bonusnum) {
        List<Integer> bonusCounts = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Set<Integer> originalLottoNumbers = new HashSet<>(lotto.getNumbers()); // 로또 번호 복사본 생성
            Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
            lottoNumbers.retainAll(winningNumbers);

            if (lottoNumbers.size() == 5 && originalLottoNumbers.contains(bonusnum)) {
                bonusCounts.add(1);
                continue;
            }
            bonusCounts.add(0);

        }

        return bonusCounts;
    }
}
