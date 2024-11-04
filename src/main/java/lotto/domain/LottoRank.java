package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import lotto.application.service.vo.MatchingInfo;

public enum LottoRank {
    FIFTH(3, false, BigDecimal.valueOf(5000)),
    FOURTH(4, false, BigDecimal.valueOf(50000)),
    THIRD(5, false, BigDecimal.valueOf(1500000)),
    SECOND(5, true, BigDecimal.valueOf(30000000)),
    FIRST(6, false, BigDecimal.valueOf(2000000000));

    private int matchedCount;
    private boolean requireBonusNumber;
    private BigDecimal prize;

    LottoRank(int matchedCount, boolean requireBonusNumber, BigDecimal prize) {
        this.matchedCount = matchedCount;
        this.requireBonusNumber = requireBonusNumber;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isRequireBonusNumber() {
        return requireBonusNumber;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public static LottoRank findByMatchingInfo(MatchingInfo matchingInfo) {
        if (matchingInfo.isEqualBonusNumber()) {
            return SECOND;
        }
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchedCount == matchingInfo.count())
                .findFirst()
                .orElse(null);
    }
}
