package lotto.interfaces.prize;

import lotto.domain.prize.LottoPrize;

public record LottoPrizeResponse(
        int matchCount,
        boolean isBonusNumberRequired,
        int prize,
        int prizeCount
) {
    public static LottoPrizeResponse of(LottoPrize lottoPrize, Integer prizeCount) {
        return new LottoPrizeResponse(
                lottoPrize.getMatchCount(),
                lottoPrize.isBonusNumberMatchRequired(),
                lottoPrize.getPrize(),
                prizeCount);
    }
}
