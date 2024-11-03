package lotto.core.dto;

import lotto.core.model.LottoPurchaseAmount;

public record LottoPurchaseAmountDto(Integer value, Integer lottoCount) {

    public static LottoPurchaseAmountDto modelOf(LottoPurchaseAmount amount) {
        return new LottoPurchaseAmountDto(amount.getValue(), amount.getLottoCount());
    }
}
