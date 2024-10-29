package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class LottoService {
    public List<Lotto> createLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> {
                    List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Collections.sort(lottoNumbers);
                    return new Lotto(lottoNumbers);
                })
                .collect(Collectors.toList());

    }

    public LottoRank compareLottoNumber(Set<Integer> userNumbers, Set<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) userNumbers.stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = userNumbers.contains(bonusNumber);
        return determineRank(matchCount, bonusMatch);
    }

    private LottoRank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return LottoRank.FIRST;
        if (matchCount == 5 && bonusMatch) return LottoRank.SECOND;
        if (matchCount == 5) return LottoRank.THIRD;
        if (matchCount == 4) return LottoRank.FOURTH;
        if (matchCount == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }



}
