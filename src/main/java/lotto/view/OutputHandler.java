package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputHandler {
    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%s개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
