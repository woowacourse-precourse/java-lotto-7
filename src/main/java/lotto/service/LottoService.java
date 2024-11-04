package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.LottoRank;

import java.util.*;

public class LottoService {

    public List<Lotto> generateLotto(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / 1000;
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lotto.add(new Lotto(randomNumbers));
        }

        return lotto;
    }

    public Map<LottoRank, Integer> calculateLottoResults(List<Lotto> userLotto, Lotto winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> resultMap = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }

        for (Lotto lotto : userLotto) {
            int matchCount = lotto.matchWinningNumbers(winningNumbers.getLotto());
            boolean bonusMatch = lotto.getLotto().contains(bonusNumber);

            LottoRank rank = LottoRank.getRank(matchCount, bonusMatch);
            resultMap.put(rank, resultMap.get(rank) + 1);
        }

        return resultMap;
    }
}
