package lotto.interfaces.ticket;

import java.util.List;
import lotto.domain.ticket.LottoTicket;
import lotto.interfaces.lotto.LottoResponse;

public record LottoTicketResponse(
        int lottoCount,
        List<LottoResponse> lottos
) {
    public static LottoTicketResponse from(LottoTicket lottoTicket) {
        return new LottoTicketResponse(lottoTicket.getLottoTicket().size(),
                lottoTicket.getLottoTicket().stream()
                        .map(LottoResponse::from)
                        .toList()
        );
    }
}
