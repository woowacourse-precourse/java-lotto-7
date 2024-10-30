package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    RANK_FIVE( "3개 일치(5,000원)", 3),
    RANK_FOUR( "4개 일치 (50,000원)", 4),
    RANK_THREE( "5개 일치 (1,500,000원)", 5),
    RANK_TWO( "5개 일치, 보너스 볼 일치 (30,000,000원)", 15),
    RANK_ONE( "6개 일치 (2,000,000,000원)", 6);

    private final String message;
    private final int lottoScore;

    LottoRank(String message, int lottoScore) {
        this.message = message;
        this.lottoScore = lottoScore;
    }

    public static LottoRank findRank(int lottoScore) {
        return Arrays.stream(LottoRank.values()).filter(lottoRank -> lottoRank.lottoScore == lottoScore).findFirst().orElse(null);
    }

    public String getMessage() {
        return message;
    }

    public int getLottoScore() {
        return lottoScore;
    }
}
