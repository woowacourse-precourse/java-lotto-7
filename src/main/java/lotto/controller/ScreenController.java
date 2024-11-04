package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoTicketRepository;
import lotto.repository.WinningReceiptRepository;
import lotto.service.constant.prize.PrizeCondition;
import lotto.service.constant.prize.PrizeConditionImpl;
import lotto.service.lotteryhost.ProfitRateServiceImpl;
import lotto.view.Output;

public class ScreenController {

    private final LottoTicketRepository lottoTicket = LottoTicketRepository.getTicket();

    public void printMyLottery() {
        Output.purchaseAmount(lottoTicket.unrevealedGameCount());
        printAllGames();
    }

    private void printAllGames() {
        List<Lotto> receipt = lottoTicket.getReceipt();
        for (Lotto lotto : receipt) {
            printGames(lotto.getNumbers());
        }
        System.out.println();
    }

    private void printGames(List<Integer> games) {
        System.out.println(games);
    }

}
