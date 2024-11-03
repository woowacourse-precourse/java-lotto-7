package lotto.domain.lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lotto.exception.lotto.InvalidLottoNumberException;

public class Lottery {

    private static final BigDecimal LOTTO_UNIT_PRICE = BigDecimal.valueOf(1000);
    private static final int SCALE = 1;

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
        return profit.divide(purchaseAmount)
                .multiply(BigDecimal.valueOf(100))
                .setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }

    private void validateBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidLottoNumberException("보너스 번호가 로또에 포함되어서는 안됩니다");
        }
    }

    private LottoResult calculateLottoResult() {
        LottoResult result = new LottoResult();
        for (Lotto lotto : drawnLottos) {
            Optional<LottoRank> rank = getRank(lotto);
            if (rank.isEmpty()) {
                continue;
            }
            result.add(rank.get());
        }
        return result;
    }

    private Optional<LottoRank> getRank(final Lotto lotto) {
        int matchingCount = lotto.countMatchingNumber(winningLotto);
        boolean isBonus = lotto.doesMatchBonusNumber(bonusNumber);
        return LottoRank.findRank(matchingCount, isBonus);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
