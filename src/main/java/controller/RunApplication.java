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
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNum = new BonusNumber();

        while(true) {
            try {
                String purchaseAmount = input.inputPurchaseAmount();
                int lottoPurchased = playerBuyLotto.purchasedLottoNums(purchaseAmount);
                List<Lotto> LottosObject = output.printPurchasedLotto(lottoPurchased);
                String inputtedWinningNumbers = input.inputWinningNumbers();
                List<Integer> winningNumbers = winningNum.generateWinningNumbers(inputtedWinningNumbers);
                String inputtedBonusNumber = input.inputBonusNumber();
                int bonusNumber = bonusNum.generateBonusNumber(inputtedBonusNumber);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
