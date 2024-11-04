package lotto;

import static lotto.view.InputView.inputWinningLotto;
import static lotto.view.ResultView.printLottos;

import java.util.ArrayList;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrize;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputView.inputMoney();

            ArrayList<Lotto> lottos = LottoManager.createLottos(money);
            printLottos(lottos);

            WinningLotto winningLotto = inputWinningLotto();

            ArrayList<LottoPrize> prizes = new ArrayList<>(LottoManager.matchLottos(winningLotto, lottos));
            ResultView.printPrize(prizes);
            ResultView.printProfit(LottoManager.calculateProfit(prizes, money));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
