package lotto.controller;

import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class ResultController {
    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public ResultController(InputView inputView, LottoMachine lottoMachine, OutputView outputView) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    public void result() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
        lottoMachine.calculateResult(winningNumbers, bonusNumber);
        outputView.printResult(lottoMachine.getResult());
        outputView.printProfitRate(lottoMachine.getResult(), lottoMachine.getPurchaseMoney());
    }
}
