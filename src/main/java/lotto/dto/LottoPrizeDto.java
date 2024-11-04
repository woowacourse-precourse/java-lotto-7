package lotto.dto;

import lotto.model.domain.LottoPrize;

public class LottoPrizeDto {

    private LottoPrize lottoPrize;

    public LottoPrizeDto(LottoPrize lottoPrize) {
        this.lottoPrize = lottoPrize;
    }

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }

    public void setLottoPrize(LottoPrize lottoPrize) {
        this.lottoPrize = lottoPrize;
    }
}
