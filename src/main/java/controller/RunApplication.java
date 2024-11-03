package controller;

import domain.*;
import view.Input;
import view.Output;

import java.util.List;

public class RunApplication {

    public void run() {

        Input input = new Input();
        Output output = new Output();
        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();
        ManageNumbers manageNumbers = new ManageNumbers();

        while(true) {
            try {
                String purchaseAmount = input.inputPurchaseAmount();
                int lottoPurchased = playerBuyLotto.purchasedLottoNums(purchaseAmount);
                List<Lotto> LottosObject = output.printPurchasedLotto(lottoPurchased);
                String winningNumbers = input.inputWinningNumbers();
                WinningNumbers winningNumObject = manageNumbers.generateWinningNumbers(winningNumbers);
                String bonusNumber = input.inputBonusNumber();
                BonusNumber bonusNumObject = manageNumbers.geterateBonusNumber(bonusNumber);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
