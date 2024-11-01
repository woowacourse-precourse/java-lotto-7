package lotto.core.service;

import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.model.LottoPurchaseAmount;

public class CreateLottoPurchaseAmountService {

    public LottoPurchaseAmountDto create(String value) {
        LottoPurchaseAmount amount = new LottoPurchaseAmount(value);
        return new LottoPurchaseAmountDto(amount.getValue(), amount.getLottoCount());
    }

}
