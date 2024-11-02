package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.exception.InvalidLottoNumberException;

public class Lottery {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;
    private final List<Lotto> pickedLottos;

    public Lottery(final Lotto winningLotto, final LottoNumber bonusNumber, final List<Lotto> lottos) {
        validateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.pickedLottos = lottos;
    }

    public void validateBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidLottoNumberException("보너스 번호가 로또에 포함되어서는 안됩니다");
        }
    }

    public Map<LottoRank, BigDecimal> calculateWinningResult() {
        Map<LottoRank, BigDecimal> map = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            map.put(lottoRank, BigDecimal.ZERO);
        }
        for (Lotto lotto : pickedLottos) {
            int matchingCount = lotto.countMatchingNumber(winningLotto);
            boolean isBonus = lotto.doesMatchBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.findRank(matchingCount, isBonus);
            map.put(rank, map.get(rank).add(BigDecimal.ONE));
        }
        return map;
    }
}
