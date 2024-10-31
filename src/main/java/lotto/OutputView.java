package lotto;

import java.util.List;

public class OutputView {

    public static void showLotties(List<Lotto> lotties) {
        System.out.println(lotties.size() + "개를 구매했습니다.");
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getNumbers());
        }
    }
}
