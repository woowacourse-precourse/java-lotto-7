package lotto.View;

import java.util.List;
import lotto.Model.Lotto;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

}
