package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.lottoForm.WinningNumbers;
import lotto.handler.MoneyInputHandler;
import lotto.handler.WinningNumbersInputHandler;
import lotto.view.OutputView;

import static lotto.view.OutputView.showLottosInfo;

public class Application {
    public static void main(String[] args) {
        MoneyInputHandler moneyInputHandler = new MoneyInputHandler();
        long lottoCount = moneyInputHandler.getLottoCount();

        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.issue(lottoCount);
        showLottosInfo(lottos);

        WinningNumbersInputHandler NumbersInputHandler = new WinningNumbersInputHandler();
        WinningNumbers winningNumbers = NumbersInputHandler.getWinningNumbers();
        int bonusNumber = NumbersInputHandler.getBonusNumber(winningNumbers);

        LottoController lottoController = new LottoController(lottos, winningNumbers, bonusNumber);
        lottoController.evaluate();

        OutputView.showResult();
    }
}
