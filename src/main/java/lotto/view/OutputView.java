package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String NUMBER_OF_PURCHASE_MESSAGE = "\n%d개를 구매했습니다.";

    public static void printPurchases(int number, List<Lotto> lottos) {
        System.out.println(String.format(NUMBER_OF_PURCHASE_MESSAGE, number));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
