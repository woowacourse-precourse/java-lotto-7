package lotto.domain.lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lotto.exception.lotto.InvalidLottoNumberException;

public class Lottery {

    private static final BigDecimal LOTTO_UNIT_PRICE = BigDecimal.valueOf(1000);

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;
    private final List<Lotto> drawnLottos;
    private final LottoResult lottoResult;

    public Lottery(final Lotto winningLotto, final LottoNumber bonusNumber, final List<Lotto> lottos) {
        validateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.drawnLottos = lottos;
        this.lottoResult = calculateLottoResult();
    }

    public BigDecimal calculateProfitRate() {
        BigDecimal profit = lottoResult.calculateProfit();
        BigDecimal purchaseAmount = LOTTO_UNIT_PRICE.multiply(BigDecimal.valueOf(drawnLottos.size()));
        return profit.divide(purchaseAmount, 1, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }

    private void validateBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidLottoNumberException("보너스 번호가 로또에 포함되어서는 안됩니다");
        }
    }

    private LottoResult calculateLottoResult() {
        LottoResult result = new LottoResult();
        for (Lotto lotto : drawnLottos) {
            int matchingCount = lotto.countMatchingNumber(winningLotto);
            boolean isBonus = lotto.doesMatchBonusNumber(bonusNumber);
            Optional<LottoRank> rank = LottoRank.findRank(matchingCount, isBonus);
            if (rank.isEmpty()) {
                continue;
            }
            result.add(rank.get());
        }
        return result;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
