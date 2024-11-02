package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        String inpuMoney = InputView.readInputMoney();
        Lotto winningLotto = new Lotto(InputView.readAndSplitWinningNumber());
    }
}
