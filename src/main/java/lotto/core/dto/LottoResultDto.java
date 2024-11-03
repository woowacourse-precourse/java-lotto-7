package lotto.core.dto;

import java.math.BigDecimal;
import java.util.List;
import lotto.core.model.LottoResult;
import lotto.core.enums.WinningRank;

public record LottoResultDto(LottoTicketDto ticket,
                             List<WinningRank> winningRanks,
                             BigDecimal rateOfReturn) {

    public static LottoResultDto modelOf(LottoResult result) {
        LottoTicketDto ticketDto = LottoTicketDto.modelOf(result.getTicket());
        return new LottoResultDto(ticketDto, result.getWinningRanks(), result.getRateOfReturn());
    }
}
