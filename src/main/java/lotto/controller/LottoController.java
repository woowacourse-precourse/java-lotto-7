package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningInformation;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningPrize;
import lotto.service.Calculator;
import lotto.service.Random;
import lotto.service.WinningNumberParser;
import lotto.view.InputView;

public class LottoController {

    private static final InputView inputView = new InputView();

    public PurchaseAmount buyLotto() {
        PurchaseAmount purchaseAmount;
        while (true) {
            try {
                String purchasePrice = inputView.inputPurchase();
                purchaseAmount = new PurchaseAmount(purchasePrice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    public List<Lotto> issueLotto(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < purchaseAmount.getCanBuyLottoCount(); i++) {
            lottos.add(new Lotto(random.NumberIssue(1, 45, 6)));
        }

        return lottos;
    }

    public void issueWinningNumber() {
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                WinningNumberParser winningNumberParser = new WinningNumberParser();

                List<Integer> winningNumber = winningNumberParser.split(winningNumbers);
                WinningNumbers.initialInstance(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void issueBonusNumber() {
        while (true) {
            try {
                String userInput = inputView.inputBonusNumber();
                BonusNumber.initialInstance(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void calculateWinning(List<Lotto> lottos) {
        Calculator calculator = new Calculator();

        for (Lotto lotto : lottos) {
            int count = calculator.matchCount(lotto);
            WinningPrize rank = calculator.rank(count, lotto, BonusNumber.getInstance());
            WinningInformation.getInstance().addWinningCount(rank);
        }
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount) {
        Calculator calculator = new Calculator();
        return calculator.rateOfReturn(purchaseAmount);
    }
}
