package lotto.controller;

import lotto.exception.InvalidBonusNumberException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumbersException;
import lotto.model.BonusNumber;
import lotto.model.PublishLotteries;
import lotto.model.Purchase;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private Purchase purchase;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private PublishLotteries publishLotteries;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void play() {
        buy();
        assign();
        showResult();
    }

    private void buy() {
        inputPurchaseAmount();
        publishLotto();
        printPublishedLotto();
    }

    private void assign() {
        assignWinningNumbers();
        assignBonusNumber();
    }

    private void showResult() {
        calculateWinnings();
        calculateTotalRateOfReturn();
        printWinningStatistics();
    }

    // 로또 구입 금액을 입력 받는다
    private void inputPurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.getPurchaseAmount();
                purchase = new Purchase(amount);
                break;
            } catch (InvalidPurchaseAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 구매한 로또 수 만큼의 로또를 발행한다
    private void publishLotto() {
        publishLotteries = new PublishLotteries(purchase.getPurchaseCount());
    }

    // 발행된 로또 번호를 출력한다
    private void printPublishedLotto() {
        outputView.printPublishedLotteries(publishLotteries.get());
    }

    // 당첨 번호를 입력 받는다
    private void assignWinningNumbers() {
        while (true) {
            try {
                List<Integer> input = inputView.getWinningNumbers();
                winningNumbers = new WinningNumbers(input);
                break;
            } catch (InvalidWinningNumbersException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호를 입력 받는다
    private void assignBonusNumber() {
        while (true) {
            try {
                int number = inputView.getBonusNumber();
                bonusNumber = new BonusNumber(number);
                break;
            } catch (InvalidBonusNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 번호를 비교하여 당첨 내역을 계산한다
    private void calculateWinnings() {

    }

    // 총 수익률을 계산한다
    private void calculateTotalRateOfReturn() {

    }

    // 당첨 통계를 출력한다
    private void printWinningStatistics() {

    }

}
