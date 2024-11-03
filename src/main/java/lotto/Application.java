package lotto;

import static lotto.view.InputView.inputWinningLotto;
import static lotto.view.ResultView.printLottos;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        try {
            int money = InputView.inputMoney();
            ArrayList<Lotto> lottos = LottoManager.createLottos(money);
            printLottos(lottos);

            WinningLotto winningLotto = inputWinningLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
