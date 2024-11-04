package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.LottoRank;

import java.util.*;

public class LottoService {

    private final int PRICE_PER_LOTTO = 1000;
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private final int LOTTO_COUNT = 6;

    public List<Lotto> generateLotto(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / PRICE_PER_LOTTO;
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
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
