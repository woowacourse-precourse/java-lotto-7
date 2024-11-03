package lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printPurchasedLottos(Lottos lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        System.out.println(String.join("\n", lottos.getAllLottoNumbers()));
    }
}
