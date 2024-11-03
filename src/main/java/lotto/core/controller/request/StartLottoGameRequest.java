package lotto.core.controller.request;

import java.util.List;

public record StartLottoGameRequest(
        LottoPurchaseAmountRequest amount,
        List<LottoRequest> lottos
) implements Request {

    public record LottoPurchaseAmountRequest(
            Integer value,
            Integer lottoCount
    ) {}

    public record LottoRequest(
            List<Integer> numbers
    ) {}
}
