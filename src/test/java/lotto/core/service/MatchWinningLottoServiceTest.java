package lotto.core.service;

import java.math.BigDecimal;
import java.util.List;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoResultDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.enums.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchWinningLottoServiceTest {

    private MatchWinningLottoService service;

    @BeforeEach
    void setUp() {
        service = new MatchWinningLottoService();
    }

    @Test
    void match_should_be_pass() {
        // given
        LottoPurchaseAmountDto amountDto = new LottoPurchaseAmountDto(1000, 1);
        List<LottoDto> lottoDtos = List.of(new LottoDto(List.of(1, 2, 3, 4, 5, 6)));
        LottoTicketDto ticketDto = new LottoTicketDto(amountDto, lottoDtos);
        LottoDto winningLottoDto = new LottoDto(List.of(1, 2, 3, 4, 5, 7));
        LottoNumberDto bonusNumberDto = new LottoNumberDto(6);
        // when
        LottoResultDto resultDto = service.match(ticketDto, winningLottoDto, bonusNumberDto);
        // then
        List<WinningRank> expectWinningRank = List.of(WinningRank.RANK_2);
        BigDecimal expectRateOfReturn = BigDecimal.valueOf(3_000_0000, 1);
        Assertions.assertEquals(expectWinningRank, resultDto.winningRanks());
        Assertions.assertEquals(expectRateOfReturn, resultDto.rateOfReturn());
    }
}
