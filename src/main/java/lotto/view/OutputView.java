package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printLottos(List<Lotto> lottos)  {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
