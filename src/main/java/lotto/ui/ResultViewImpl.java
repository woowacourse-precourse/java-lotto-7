package lotto.ui;

import lotto.model.Lotto;

import java.util.List;

public class ResultViewImpl implements ResultView {
    @Override
    public void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
