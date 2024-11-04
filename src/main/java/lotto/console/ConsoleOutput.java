package lotto.console;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.Output;

public class ConsoleOutput implements Output {

    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

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
}
