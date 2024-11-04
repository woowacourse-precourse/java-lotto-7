package controller;

import domain.*;
import message.Prize;
import view.Input;
import view.Output;

import java.util.List;
import java.util.Map;

public class RunApplication {

    public void run() {

        Input input = new Input();
        Output output = new Output();
        PlayerBuyLotto playerBuyLotto = new PlayerBuyLotto();
        WinningNum winningNum = new WinningNum();
        BonusNumber bonusNum = new BonusNumber();
        Validate validate = new Validate();
        WinningResult winningResult = new WinningResult();

        while(true) {
            try {
                String purchaseAmount = input.inputPurchaseAmount();
                int lottoPurchased = playerBuyLotto.purchasedLottoNums(purchaseAmount);
                List<Lotto> lottery = output.printPurchasedLotto(lottoPurchased);
                String inputtedWinningNumbers = input.inputWinningNumbers();
                List<Integer> winningNumbers = winningNum.generateWinningNumbers(inputtedWinningNumbers);
                String inputtedBonusNumber = input.inputBonusNumber();
                int bonusNumber = bonusNum.generateBonusNumber(inputtedBonusNumber);
                validate.validateBonusNumAndWinningNum(winningNumbers, bonusNumber);
                output.printStaticGuide();
                winningResult.results(lottery, winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
