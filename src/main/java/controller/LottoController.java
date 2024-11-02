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
        int amount = inputView.purchaseAmount();
        purchaseAmount = new Amount(amount);
        lottoAmount = new LottoAmount(purchaseAmount.getPurchaseAmount());
        outputView.printLottoAmount(lottoAmount);

        makeLotto();
        outputView.printLottos(lottoCollection);
        makeWinningNum();
        bonusNumber = new BonusNumber(winningLottoNum, inputView.bonusNum());

        resultFactory = new ResultFactory(lottoCollection,winningLottoNum,bonusNumber);
        outputView.printResult(resultFactory,purchaseAmount);
    }



    private void makeWinningNum() {
        WinningLottoNumFactory winningLottoNumFactory = new WinningLottoNumFactory(inputView.winingNumber());
        winningLottoNum = winningLottoNumFactory.get();
    }

    private void makeLotto() {
        for (int i = 0; i < lottoAmount.getCount(); i++) {
            lottoCollection.add(LottoFactory.make());
        }
    }
}
