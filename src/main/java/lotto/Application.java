package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.handler.MoneyInputHandler;
import lotto.handler.WinningNumbersInputHandler;

import static lotto.view.OutputView.showLottosInfo;

public class Application {
    public static void main(String[] args) {
        MoneyInputHandler moneyInputHandler = new MoneyInputHandler();
        long lottoCount = moneyInputHandler.getLottoCount();

        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.issue(lottoCount);
        showLottosInfo(lottos);

        WinningNumbersInputHandler winningNumbersInputHandler = new WinningNumbersInputHandler();
        WinningNumbers winningNumbers = winningNumbersInputHandler.getWinningNumbers();
    }
}
