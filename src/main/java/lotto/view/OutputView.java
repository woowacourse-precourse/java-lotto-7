package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private static final String BUY_LOTTOS_STATEMENT = "%d개를 구매했습니다.";

    public void printLottos(Lottos lottos) {
        System.out.printf(System.lineSeparator() + BUY_LOTTOS_STATEMENT + System.lineSeparator(),
                lottos.getLottos().size());

        lottos.getLottos().forEach(this::printEachLotto);
    }

    private void printEachLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
