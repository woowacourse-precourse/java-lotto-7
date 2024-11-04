package lotto.domain.lotto;

import static lotto.domain.price.Price.LOTTO_UNIT_PRICE;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import lotto.exception.state.InvalidStateException;
import lotto.exception.argument.lotto.InvalidLottoNumberException;

public class Lottery {

    private static final int SCALE = 1;

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;
    private final List<Lotto> lottos;
    private final Map<LottoRank, BigDecimal> results;

    public Lottery(final Lotto winningLotto, final LottoNumber bonusNumber, final List<Lotto> lottos) {
        validateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
        this.results = calculateWinningResults();
    }

    public BigDecimal calculateProfitRate() {
        if (lottos.isEmpty()) {
            throw new InvalidStateException("구매한 로또가 없습니다.");
        }
        BigDecimal profit = calculateProfit();
        BigDecimal purchaseAmount = LOTTO_UNIT_PRICE.multiply(BigDecimal.valueOf(lottos.size()));
        return profit.divide(purchaseAmount)
                .multiply(BigDecimal.valueOf(100))
                .setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }

    private void validateBonusNumber(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new InvalidLottoNumberException("보너스 번호가 로또에 포함되어서는 안됩니다.");
        }
    }

    private Map<LottoRank, BigDecimal> calculateWinningResults() {
        Map<LottoRank, BigDecimal> results = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            results.put(lottoRank, BigDecimal.ZERO);
        }
        for (Lotto lotto : lottos) {
            getRank(lotto).ifPresent(lottoRank ->
                    results.put(lottoRank, results.get(lottoRank).add(BigDecimal.ONE)));
        }
        return Collections.unmodifiableMap(results);
    }

    private BigDecimal calculateProfit() {
        BigDecimal profit = BigDecimal.ZERO;
        for (Entry<LottoRank, BigDecimal> entry : results.entrySet()) {
            profit = profit.add(entry.getKey().getAward().multiply(entry.getValue()));
        }
        return profit;
    }

    private Optional<LottoRank> getRank(final Lotto lotto) {
        int matchingCount = lotto.countMatchingNumber(winningLotto);
        boolean isBonus = lotto.doesMatchBonusNumber(bonusNumber);
        return LottoRank.findRank(matchingCount, isBonus);
    }

    public BigDecimal get(LottoRank lottoRank) {
        return results.get(lottoRank);
    }
}
