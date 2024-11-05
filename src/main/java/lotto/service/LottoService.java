package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Rank;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyAmount;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import static lotto.constant.LottoConstants.LOTTO_SIZE;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.MAX_NUMBER;

public class LottoService {
    private final List<Lotto> lottos;

    public LottoService() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> buyLottos(LottoBuyAmount amount) {
        for (int i = 0; i < amount.getLottoBuyCount(); i++) {
            lottos.add(new Lotto(pickRandomNumbers()));
        }
        return lottos;
    }

    public LottoResult calculateResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.countMatchingNumbers(lotto);
            boolean hasBonus = bonusNumber.containsBonusNumber(lotto);
            record(result, matchCount, hasBonus);
        }
        result.calculateProfitRate(lottos.size());
        return result;
    }

    protected List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER,
                MAX_NUMBER,
                LOTTO_SIZE
        );
    }

    private void record(LottoResult result, int matchCount, boolean hasBonus) {
        Rank rank = Rank.getRank(matchCount, hasBonus);

        if (rank.getMatchCount() != 0) {
            result.recordMatch(rank);
        }
    }
}
