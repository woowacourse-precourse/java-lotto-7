package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    RANK_FIVE( 3, 5_000, "3개 일치(5,000원)"),
    RANK_FOUR( 4, 50_000, "4개 일치 (50,000원)"),
    RANK_THREE( 5, 1_500_000, "5개 일치 (1,500,000원)"),
    RANK_TWO( 15, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_ONE( 6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final String message;
    private final int prize;
    private final int lottoScore;

    LottoRank(int lottoScore, int prize, String message) {
        this.lottoScore = lottoScore;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank findRank(int lottoScore) {
        return Arrays.stream(LottoRank.values()).filter(lottoRank -> lottoRank.lottoScore == lottoScore).findFirst().orElse(null);
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }

    public int getLottoScore() {
        return lottoScore;
    }
}
