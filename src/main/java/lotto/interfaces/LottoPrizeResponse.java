package lotto.interfaces;

import lotto.domain.matcher.LottoPrize;

public record LottoPrizeResponse(
        int matchCount,
        int prize,
        int prizeCount
) {
    public static LottoPrizeResponse of(LottoPrize lottoPrize, Integer prizeCount) {
        return new LottoPrizeResponse(lottoPrize.getMatchCount(), lottoPrize.getPrize(), prizeCount);
    }
}
