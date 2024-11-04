package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public Lottos generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<Lotto>();

        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE));
            lottos.add(lotto);
        }
        return new Lottos(lottos, lottoCount);
    }

    public LottoRanks getResult(Lottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        LottoRanks ranks = new LottoRanks();

        purchasedLottos.getLottos().forEach(lotto -> {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = (matchCount == 5) && lotto.getNumbers().contains(bonusNumber.getBonusNumber());
            ranks.updateWinningCounts(matchCount, bonusMatch);
        });

        return ranks;
    }

    public int countMatchingNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }
}
