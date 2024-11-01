package lotto.view;

import lotto.model.Lotto;
import java.util.List;

public class OutputView {
    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}