package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.lottoForm.WinningNumbers;
import lotto.domain.number.BonusNumber;
import lotto.handler.MoneyInputHandler;
import lotto.handler.NumbersInputHandler;

import static lotto.view.OutputView.*;

public class LottoController {
    private final MoneyInputHandler moneyInputHandler;
    private final LottoMachine lottoMachine;
    private final NumbersInputHandler numbersInputHandler;

    public LottoController() {
        moneyInputHandler = new MoneyInputHandler();
        lottoMachine = new LottoMachine();
        numbersInputHandler = new NumbersInputHandler();
    }

    public void run() {
        long lottoCount = moneyInputHandler.getLottoCount();
        Lottos lottos = lottoMachine.issue(lottoCount);
        showLottosInfo(lottos);

        WinningNumbers winningNumbers = numbersInputHandler.getWinningNumbers();
        BonusNumber bonusNumber = numbersInputHandler.getBonusNumber(winningNumbers);
        lottos.compare(winningNumbers, bonusNumber);

        showResult();
        showProfitRate(lottoCount, Result.calculateProfitSum());
    }
}
