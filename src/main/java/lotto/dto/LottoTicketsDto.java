package lotto.dto;

import java.util.List;
import lotto.common.model.Lotto;

public record LottoTicketsDto (List<Lotto> LottoTickets) {
    private static LottoTicketsDto lottoTicketsDto;

    public LottoTicketsDto {
        lottoTicketsDto = new LottoTicketsDto(LottoTickets);
    }

    public static LottoTicketsDto getLottoTicketsDto() {
        return lottoTicketsDto;
    }
}
