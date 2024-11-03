package lotto.ui;

import lotto.model.Lotto;
import lotto.model.LottoGame;

import java.util.List;

public class ResultViewImpl implements ResultView {
    @Override
    public void displayLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoGame lottoGame) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(lottoGame.getLottoResult());
        lottoGame.printReturnRate();
    }
}
