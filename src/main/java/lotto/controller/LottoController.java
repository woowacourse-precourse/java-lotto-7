package lotto.controller;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.model.PublishLotteries;
import lotto.model.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private int purchaseCount;
    private PublishLotteries publishLotteries;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView =  outputView;
    }

    public void play() {
        buy();
        assign();
        showResult();
    }

    public void buy() {
        inputPurchaseAmount();
        publishLotto();
        printPublishedLotto();
    }

    public void assign() {
        assignWinningNumbers();
        assignBonusNumber();
    }

    public void showResult() {
        calculateWinnings();
        calculateTotalRateOfReturn();
        printWinningStatistics();
    }

    // 로또 구입 금액을 입력 받는다
    public void inputPurchaseAmount() {
        while (true) {
            try {
                int amount = inputView.getPurchaseAmount();
                PurchasePrice purchasePrice = new PurchasePrice(amount);
                purchaseCount = purchasePrice.get() / 1000;
                break;
            } catch (InvalidPurchaseAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 구매한 로또 수 만큼의 로또를 발행한다
    public void publishLotto() {
        publishLotteries = new PublishLotteries(purchaseCount);
    }

    // 발행된 로또 번호를 출력한다
    public void printPublishedLotto() {
        outputView.printPublishedLotteries(publishLotteries.get());
    }

    // 당첨 번호를 입력 받는다
    public void assignWinningNumbers() {

    }

    // 보너스 번호를 입력 받는다
    public void assignBonusNumber() {

    }

    // 번호를 비교하여 당첨 내역을 계산한다
    public void calculateWinnings() {

    }

    // 총 수익률을 계산한다
    public void calculateTotalRateOfReturn() {

    }

    // 당첨 통계를 출력한다
    public void printWinningStatistics() {

    }

}
