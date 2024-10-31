package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public void showLottos(List<Lotto> lottos) {
        System.out.println("\n8개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.print(lotto.toString() + "\n");
        });
    }
}
