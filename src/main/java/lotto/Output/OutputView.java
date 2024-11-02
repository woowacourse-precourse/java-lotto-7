package lotto.Output;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
