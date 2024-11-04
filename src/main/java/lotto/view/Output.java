package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class Output {
    public void printPayResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

    }
}
