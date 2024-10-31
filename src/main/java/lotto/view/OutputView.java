package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void outputPurchaseAmount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
