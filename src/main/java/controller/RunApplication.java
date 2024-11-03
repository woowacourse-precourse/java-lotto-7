package controller;

import domain.Lotto;
import domain.ManageNumbers;
import domain.PlayerBuyLotto;
import domain.WinningNumbers;
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
                List<Lotto> Lottos = output.printPurchasedLotto(lottoPurchased);
                String winningNumbers = input.inputWinningNumbers();
                WinningNumbers winningNumbers1 = manageNumbers.generateWinningNumbers(winningNumbers);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
