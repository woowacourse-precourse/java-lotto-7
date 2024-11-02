package lotto.controller;

import lotto.application.LottoTicketsDto;
import lotto.domain.Rank;
import lotto.service.LottoService;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {
    LottoService lottoService = new LottoService();

    public void run() {
        int userMoney = readUserMoney();
        LottoTicketsDto lottoTicketsDto = lottoService.createLottoTickets(userMoney);
        printLottoTickets(lottoTicketsDto);

        List<Rank> userRanks = lottoService.calculateRank(lottoTicketsDto, readWinningLotto(), readBonusNumber());
        printUserRanks(userRanks);

        printRateOfReturn(lottoService.calculateRateOfReturn(userMoney, userRanks));
    }
}
