package lotto.controller.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;

import java.util.List;

public record LottoPurchaseResponse(int amount, List<Lotto> lottoList) {

    public static LottoPurchaseResponse of(LottoPurchase lottoPurchase, List<Lotto> lottoList) {
        return new LottoPurchaseResponse(lottoPurchase.getAmount(), lottoList);
    }

}
