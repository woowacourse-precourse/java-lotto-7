package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";

    public static void displayPurchasedLottoNumbers(Lottos lottos) {
        printPurchaseQuantity(lottos.getLottoCount());
        printLottoNumbers(lottos.getLottos());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printPurchaseQuantity(int lottoQuantity) {
        String message = String.format("%s%d %s", LINE_BREAK, lottoQuantity, PURCHASE_QUANTITY_MESSAGE);
        System.out.println(message);
    }
}
