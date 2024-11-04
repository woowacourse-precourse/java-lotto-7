package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void printWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        String purchase_msg = LOTTO_PURCHASE_MESSAGE.formatted(lottos.size());
        
        System.out.println(purchase_msg);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }
}
