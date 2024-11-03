package lotto.view;

import java.util.HashMap;
import lotto.constant.Prize;
import lotto.constant.Prompt;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.service.LottoService;

public class OutputView {
    private static final LottoService lottoService = new LottoService();

    private OutputView() {
    }

    public static void printBoughtLottos(Lottos lottos, Money money) {
        int ticketCount = lottoService.getTicketCount(money);
        System.out.printf((Prompt.CONFIRM_TICKET_COUNT.getMessage()) + "%n", ticketCount);

        lottos.getLottos()
                .forEach(Lotto::printNumbers);
    }

    public static void printResults(Result result) {
        HashMap<Prize, Integer> prizeResult = result.getPrizeResult();

        for (Prize prize: Prize.values()) {
            if (prize == Prize.NONE)
                continue;
            String message = prize.getMessage();
            int count = prizeResult.get(prize);
            System.out.printf((message + "%n"), count);

        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf((Prompt.EARNING_RATE.getMessage()) + "%n", earningRate);
    }
}
