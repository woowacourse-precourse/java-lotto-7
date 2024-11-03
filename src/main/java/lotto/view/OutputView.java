package lotto.view;

import java.util.Arrays;
import lotto.constant.Prompt;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;

public class OutputView {
    private static final LottoService lottoService = new LottoService();

    private OutputView() {}

    public static void printBoughtLottos(Lottos lottos, Money money) {
        int ticketCount = lottoService.getTicketCount(money);
        System.out.printf((Prompt.CONFIRM_TICKET_COUNT.getMessage()) + "%n", ticketCount);

        lottos.getLottos()
                .forEach(Lotto::printNumbers);
    }

//    public static void
}
