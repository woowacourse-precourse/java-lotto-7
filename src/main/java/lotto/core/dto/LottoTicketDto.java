package lotto.core.dto;

import java.util.List;
import lotto.core.model.LottoTicket;

public record LottoTicketDto(List<LottoDto> lottos) {

    public static LottoTicketDto modelOf(LottoTicket lottoTicket) {
        List<LottoDto> lottos = lottoTicket.getLottos().stream().map(LottoDto::modelOf).toList();
        return new LottoTicketDto(lottos);
    }
}
