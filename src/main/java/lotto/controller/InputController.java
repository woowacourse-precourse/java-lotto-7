package lotto.controller;

import lotto.domain.AmountValidator;
import lotto.domain.BonusNumberValidator;
import lotto.domain.WinningNumberValidator;
import lotto.view.InputView;

import java.util.List;

public class InputController {
    private InputView inputView = new InputView();
    private AmountValidator amountValidator = new AmountValidator();
    private WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    public Integer initPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = inputView.enterPurchaseAmount();
                System.out.println();

                return amountValidator.validate(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> initWinningNumber() {
        while (true) {
            try {
                String winningNumber = inputView.enterWinningNumber();
                System.out.println();

                return winningNumberValidator.validate(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> initBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputView.enterBonsuNumber();
                System.out.println();

                return bonusNumberValidator.validate(bonusNumber, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}