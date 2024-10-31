package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    /**
     * 발행된 로또 번호들 출력
     */
    public static void printMyLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
