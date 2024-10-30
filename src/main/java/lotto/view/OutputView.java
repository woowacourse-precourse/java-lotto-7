package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.%n", lottos.size());

        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
