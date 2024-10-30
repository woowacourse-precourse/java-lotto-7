package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> Lottos = lottoMachine.buyLotto(lottoPurchaseAmount);
        OutputView.printLottos(Lottos);
    }
}
