package lotto.vo;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public enum LottoResult {
    NOT_MATCHES(0, 0, 0),
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_AND_BONUS_MATCHES(5, 1, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    private int matchingCount;
    private int prizeMoney;
    private int bonusCount;

    private final static List<LottoResult> resultGroup;
    private final static DecimalFormat decimalFormat;

    LottoResult(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    LottoResult(int matchingCount, int bonusCount, int prizeMoney) {
        this.bonusCount = bonusCount;
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    static {
        resultGroup = List.of(values());
        decimalFormat = new DecimalFormat("#,###");
    }

    public static LottoResult findByHitCount(long hitCount, long bonusCount) {
        if (hitCount == 5 && bonusCount == 1) {
            return FIVE_AND_BONUS_MATCHES;
        }
        return resultGroup.stream()
                .filter(result -> result.matchingCount == hitCount)
                .findFirst().orElse(NOT_MATCHES);
    }

    public String getResult(int hitCount) {
        return resultFormat(hitCount);
    }

    public long getTotalPrizeMoney(int hitCount) {
        return prizeMoney * hitCount;
    }

    private String resultFormat(int hitCount) {
        String prizeMoneyFormat = decimalFormat.format(prizeMoney);

        if (this.equals(FIVE_AND_BONUS_MATCHES)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", matchingCount, prizeMoneyFormat, hitCount);
        }

        if (this.equals(NOT_MATCHES)) {
            return "";
        }

        return String.format("%d개 일치 (%s원) - %d개", matchingCount, prizeMoneyFormat, hitCount);
    }
}
