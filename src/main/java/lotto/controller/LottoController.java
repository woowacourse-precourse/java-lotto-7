package lotto.controller;

import lotto.application.LottoTicketsDto;
import lotto.application.WinningNumbersDto;
import lotto.domain.Rank;
import lotto.service.LottoService;

import java.util.List;

import static lotto.view.InputView.readUserMoneyWithRetry;
import static lotto.view.InputView.readWinningNumbersWithRetry;
import static lotto.view.OutputView.*;

public class LottoController {
    LottoService lottoService = new LottoService();

    public void run() {
        int userMoney = readUserMoneyWithRetry();
        LottoTicketsDto lottoTicketsDto = lottoService.createLottoTickets(userMoney);
        printLottoTickets(lottoTicketsDto);

        WinningNumbersDto winningNumbersDto = readWinningNumbersWithRetry();
        List<Rank> userRanks = calculateRanksWithRetry(lottoTicketsDto, winningNumbersDto);
        printUserRanks(userRanks);

        printRateOfReturn(lottoService.calculateRateOfReturn(userMoney, userRanks));
    }

    private List<Rank> calculateRanksWithRetry(LottoTicketsDto lottoTicketsDto, WinningNumbersDto winningNumbersDto) {
        List<Rank> userRanks;
        while (true) {
            try {
                userRanks = lottoService.calculateRanks(lottoTicketsDto, winningNumbersDto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbersDto = readWinningNumbersWithRetry();
            }
        }

        return userRanks;
    }
}
