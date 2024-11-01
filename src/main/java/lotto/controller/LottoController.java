package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.service.impl.LottoServiceImpl;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    private List<Integer> winningNumbers = new ArrayList<>();
    private InputController inputController = new InputController();
    private LottoService lottoService;
    private OutputView outputView;
    private Integer purchaseAmount = 0;


    public void run() {
        initPurchaseAmount();
        lottoService = new LottoServiceImpl(purchaseAmount);
        outputView = new OutputView(lottoService);
        printLottos();
        initWinningNumber();
        initBonusNumber();
        printResult();
        printRateOfReturn();
    }

    private void initPurchaseAmount() {
        this.purchaseAmount = inputController.initPurchaseAmount();
    }

    private void initWinningNumber() {
        this.winningNumbers = inputController.initWinningNumber();
    }

    private void initBonusNumber() {
        this.winningNumbers = inputController.initBonusNumber(winningNumbers);
    }

    private void printLottos() {
        outputView.printLottos();
    }

    private void printResult() {
        outputView.printResult(winningNumbers);
    }

    private void printRateOfReturn() {
        outputView.printRateOfReturn();
    }
}