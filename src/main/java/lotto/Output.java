package lotto;

import java.util.List;

public class Output {

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
