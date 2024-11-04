package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResultChecker {
    public static int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        lottoSet.retainAll(new HashSet<>(winningNumbers));

        return lottoSet.size();
    }
}
