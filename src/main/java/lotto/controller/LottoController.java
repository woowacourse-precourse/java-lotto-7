package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoNumber;
import lotto.model.MatchNumbers;
import lotto.model.PurchasePrice;
import lotto.model.RandomNumber;
import lotto.util.Convertor;
import lotto.util.Sorter;
import lotto.util.Splitter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private PurchasePrice initPurchasePrice() {
        return new PurchasePrice(Convertor.stringToInt(inputView.inputPurchasePrice()));
    }

    private LottoAmount calculateLottoAmount(PurchasePrice purchasePrice) {
        return new LottoAmount(purchasePrice.get());
    }

    private void printLottoAmount(LottoAmount lottoAmount) {
        outputView.printBuyLotto(lottoAmount.get());
    }

    private LottoNumber createLottoNumber(LottoAmount lottoAmount, RandomNumber randomNumber) {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.add(lottoAmount, randomNumber);
        return lottoNumber;
    }

    private void printLottoNumber(LottoNumber lottoNumber) {
        outputView.printLottoNumber(lottoNumber.get());
    }

    private Lotto initUserNumbers() {
        return new Lotto(Sorter.sort(Convertor.arrayToList(Splitter.split(inputView.inputWinningNumbers()))));
    }

    private BonusNumber initBonusNumber(Lotto lotto) {
        return new BonusNumber(lotto.get(), Convertor.stringToInt(inputView.inputBonusNumber()));
    }

    private void printMatchResult(MatchNumbers matchNumbers) {
        outputView.printMatchNumbers(
                matchNumbers.getThreeMatch(),
                matchNumbers.getFourMatch(),
                matchNumbers.getFiveMatch(),
                matchNumbers.getFiveAndBonusMatch(),
                matchNumbers.getSixMatch()
        );
    }

    public void run() {
        PurchasePrice purchasePrice = initPurchasePrice();
        LottoAmount lottoAmount = calculateLottoAmount(purchasePrice);
        printLottoAmount(lottoAmount);

        RandomNumber randomNumber = new RandomNumber();
        LottoNumber lottoNumber = createLottoNumber(lottoAmount, randomNumber);
        printLottoNumber(lottoNumber);

        Lotto lotto = initUserNumbers();
        BonusNumber bonusNumber = initBonusNumber(lotto);

        MatchNumbers matchNumbers = new MatchNumbers();
        matchNumbers.count(lottoNumber.get(), lotto.get(), bonusNumber.get());
        printMatchResult(matchNumbers);
    }
}
