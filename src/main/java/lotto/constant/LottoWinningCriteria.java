package lotto.constant;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

public enum LottoWinningCriteria {
    FIFTH_PRIZE(3, false, 5_000),
    FOURTH_PRIZE(4, false, 50_000),
    THIRD_PRIZE(5, false, 1_500_000),
    SECOND_PRIZE(5, true, 30_000_000),
    FIRST_PRIZE(6, false, 2_000_000_000),
    ;

    private final int winningLottoMatchCount;
    private final boolean isMatchBonus;
    private final long money;

    LottoWinningCriteria(int winningLottoMatchCount, boolean isMatchBonus, long money) {
        this.winningLottoMatchCount = winningLottoMatchCount;
        this.isMatchBonus = isMatchBonus;
        this.money = money;
    }

    public static Optional<LottoWinningCriteria> findPrize(int equalCount, boolean isContainBonus) {
        for (LottoWinningCriteria criteria : LottoWinningCriteria.values()) {
            if (criteria.winningLottoMatchCount != equalCount) {
                continue;
            }
            if (equalCount == 5 && criteria.isMatchBonus != isContainBonus) {
                continue;
            }
            return Optional.of(criteria);
        }
        return Optional.empty();
    }

    public long getMoney() {
        return money;
    }

    @Override
    public String toString() {
        if (isMatchBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", winningLottoMatchCount, formatNumberWithCommas());
        }
        return String.format("%d개 일치 (%s원)", winningLottoMatchCount, formatNumberWithCommas());
    }

    private String formatNumberWithCommas() {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        return numberFormat.format(money);
    }
}
