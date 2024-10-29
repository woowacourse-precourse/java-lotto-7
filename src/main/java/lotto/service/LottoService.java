package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lotto.model.LottoRank;

public class LottoService {
    public TreeSet<Integer> makeLottoNumber() {
        TreeSet<Integer> lottoNumbers = new TreeSet<>();
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        for (int numbers : lottoNumber) {
            lottoNumbers.add(numbers);
        }

        return lottoNumbers;

    }

    public LottoRank compareLottoNumber(Set<Integer> userNumbers, Set<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) userNumbers.stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = userNumbers.contains(bonusNumber);
        return determineRank(matchCount, bonusMatch);
    }

    private LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return LottoRank.FIFTH;
        if (matchCount == 5 && bonusMatch) return LottoRank.SECOND;
        if (matchCount == 5) return LottoRank.THIRD;
        if (matchCount == 4) return LottoRank.FOURTH;
        if (matchCount == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }



}
