package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.lottoForm.WinningNumbers;
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
        showLottoInfo(lottos);

        WinningNumbers winningNumbers = numbersInputHandler.getWinningNumbers();
        LottoNumber bonusNumber = numbersInputHandler.getBonusNumber(winningNumbers);
        lottos.compare(winningNumbers, bonusNumber);

        showResult();
        showProfitRate(lottoCount, Result.calculateProfitSum());
    }
}
