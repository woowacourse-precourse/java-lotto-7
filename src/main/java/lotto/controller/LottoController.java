package lotto.controller;

import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private Integer purchaseAmount = 0;
    private List<Integer> winningNumber = new ArrayList<>();
    private InputController inputController = new InputController();


    public void run() {
        initPurchaseAmount();
        initWinningNumber();
        initBonusNumber();
    }

    private void initPurchaseAmount() {
        this.purchaseAmount = inputController.initPurchaseAmount();
    }

    private void initWinningNumber() {
        this.winningNumber = inputController.initWinningNumber();
    }

    private void initBonusNumber() {
        this.winningNumber = inputController.initBonusNumber(winningNumber);
    }
}
