package lotto.core.dto;

import java.util.List;
import lotto.core.model.LottoTicket;

public record LottoTicketDto(LottoPurchaseAmountDto amount, List<LottoDto> lottos) {

    public static LottoTicketDto modelOf(LottoTicket lottoTicket) {
        LottoPurchaseAmountDto amount = LottoPurchaseAmountDto.modelOf(lottoTicket.getAmount());
        List<LottoDto> lottos = lottoTicket.getLottos().stream().map(LottoDto::modelOf).toList();
        return new LottoTicketDto(amount, lottos);
    }
}
