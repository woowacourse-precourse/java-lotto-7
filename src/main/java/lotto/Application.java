package lotto;

import static lotto.view.InputView.inputWinningLotto;
import static lotto.view.ResultView.printLottos;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrize;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputView.inputMoney();
            ArrayList<LottoPrize> prizes = new ArrayList<>();

            ArrayList<Lotto> lottos = LottoManager.createLottos(money);
            printLottos(lottos);

            WinningLotto winningLotto = inputWinningLotto();

            for (Lotto lotto : lottos) {
                LottoPrize lottoPrize = LottoManager.matchLotto(winningLotto, lotto);
                prizes.add(lottoPrize);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
