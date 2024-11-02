package lotto.core.service;

import java.util.List;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.dto.LottoResultDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.model.Lotto;
import lotto.core.model.LottoNumber;
import lotto.core.model.LottoResult;
import lotto.core.model.LottoTicket;
import lotto.core.enums.WinningRank;

public class MatchWinningLottoService {

    public LottoResultDto match(LottoTicketDto ticketDto,
                                LottoDto winningLottoDto,
                                LottoNumberDto bonusNumberDto) {
        LottoTicket ticket = LottoTicket.dtoOf(ticketDto);
        Lotto winningLotto = Lotto.dtoOf(winningLottoDto);
        LottoNumber bonusNumber = LottoNumber.dtoOf(bonusNumberDto);

        List<WinningRank> winningRanks = ticket.getWinningRanks(winningLotto, bonusNumber);
        LottoResult winningResult = new LottoResult(ticket, winningRanks);
        return LottoResultDto.modelOf(winningResult);
    }

}
