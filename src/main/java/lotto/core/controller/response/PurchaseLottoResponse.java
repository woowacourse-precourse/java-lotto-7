package lotto.core.controller.response;

import java.util.List;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoTicketDto;

public record PurchaseLottoResponse(
        LottoPurchaseAmountResponse amount,
        List<LottoResponse> lottos
) implements Response {

    public record LottoPurchaseAmountResponse(
            Integer value,
            Integer lottoCount
    ) {}

    public record LottoResponse(
            List<Integer> numbers
    ) {}

    public static PurchaseLottoResponse dtoOf(LottoTicketDto dto) {
        LottoPurchaseAmountDto amountDto = dto.amount();
        LottoPurchaseAmountResponse amount = new LottoPurchaseAmountResponse(amountDto.value(), amountDto.lottoCount());
        List<LottoResponse> lottos = dto.lottos().stream().map(it -> new LottoResponse(it.numbers())).toList();
        return new PurchaseLottoResponse(amount, lottos);
    }
}
