package controller;

import factory.LottoFactory;
import factory.ResultFactory;
import factory.WinningLottoNumFactory;
import model.Amount;
import model.BonusNumber;
import model.LottoAmount;
import model.LottoCollection;
import model.WinningLottoNum;
import validation.Validation;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoCollection lottoCollection;
    private Amount purchaseAmount;
    private LottoAmount lottoAmount;
    private WinningLottoNum winningLottoNum;
    private BonusNumber bonusNumber;
    private ResultFactory resultFactory;

    public LottoController(InputView inputView, OutputView outputView, LottoCollection lottoCollection) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoCollection = lottoCollection;
    }

    public void run() {
        buyLotto();
        inputWinningNum();
        inputBonusNumber();
        printResult();
    }

    private void buyLotto() {
        inputAmount();
        lottoAmount = new LottoAmount(purchaseAmount.getPurchaseAmount());
        outputView.printLottoAmount(lottoAmount);
        makeLotto();
        outputView.printLottos(lottoCollection);
    }

    private int inputAmount() {
        int amount = 0;
        while (true) {
            try {
                amount = inputView.purchaseAmount();
                purchaseAmount = new Amount(amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    private void inputWinningNum() {
        while (true) {
            try {
                WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(inputView.winingNumber());
                winningLottoNum = winningLottoNumFactory.get();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                bonusNumber = new BonusNumber(winningLottoNum, inputView.bonusNum());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void makeLotto() {
        for (int i = 0; i < lottoAmount.getCount(); i++) {
            lottoCollection.add(LottoFactory.make());
        }
    }

    private void printResult() {
        resultFactory = new ResultFactory(lottoCollection, winningLottoNum, bonusNumber);
        outputView.printResult(resultFactory, purchaseAmount);
    }
}
