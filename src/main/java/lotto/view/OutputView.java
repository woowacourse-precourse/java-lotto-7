package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void printQuantity(int quantity) {
        System.out.println(NEXT_LINE + quantity + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.print(NEXT_LINE);
    }
}
