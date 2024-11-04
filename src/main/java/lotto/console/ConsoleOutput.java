package lotto.console;

import static lotto.common.Messages.PURCHASE_AMOUNT_PROMPT;
import static lotto.common.Messages.WINNING_NUMBER_PROMPT;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }

    @Override
    public void printLottos(Lottos lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printWinningLottoPrompt() {
        System.out.println("\n" + WINNING_NUMBER_PROMPT);
    }
}
