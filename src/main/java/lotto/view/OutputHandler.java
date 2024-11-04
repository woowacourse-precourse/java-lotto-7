package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.lottoNumber.RandomNumberGenerator;

public class OutputHandler {

    RandomNumberGenerator generator = new RandomNumberGenerator();

    public void printPurchasedLotto(List<Lotto> purchasedLottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchasedLottos.size());
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
