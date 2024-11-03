package lotto.domain;

import java.util.Arrays;
import lotto.application.service.vo.MatchingInfo;

public enum LottoRank {
    FIRST(6, false, "2,000,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FOURTH(4, false, "50,000"),
    FIFTH(3, false, "5,000");

    private int matchedCount;
    private boolean requireBonusNumber;
    private String prize;

    LottoRank(int matchedCount, boolean requireBonusNumber, String prize) {
        this.matchedCount = matchedCount;
        this.requireBonusNumber = requireBonusNumber;
        this.prize = prize;
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
