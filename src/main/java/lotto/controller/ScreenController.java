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
    private WinningReceiptRepository winningReceipt;

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

    public void printMyResult() {
        winningReceipt = WinningReceiptRepository.getInstance();
        Output.prizeStatistic();
        for (PrizeCondition condition : PrizeConditionImpl.values()) {
            if(condition.equals(PrizeConditionImpl.SECOND_OR_THREE_PRIZE)) continue;
            if(condition.equals(PrizeConditionImpl.SECOND_PRIZE)){
                secondWinner(condition);
                continue;
            }
            orderMatch(condition);
        }
    }

    private void orderMatch(PrizeCondition condition) {
        Output.winner(condition.getCorrectNumber(),
                condition.getPrizeMoney(),
                winningReceipt.getCount(condition));
    }

    private void secondWinner(PrizeCondition condition) {
        Output.secondWinner(condition.getCorrectNumber(),
                condition.getPrizeMoney(),
                winningReceipt.getCount(condition));
    }

    public void profitRate() {
        Output.profitRate(new ProfitRateServiceImpl().getRate());
    }
}
