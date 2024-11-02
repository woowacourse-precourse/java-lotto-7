package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private final String ISSUED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public void displayIssuedLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + ISSUED_LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
