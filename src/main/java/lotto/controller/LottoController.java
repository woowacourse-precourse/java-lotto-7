package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.LottoNumber;
import lotto.model.MatchNumbers;
import lotto.model.Profit;
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
        try {
            return new PurchasePrice(Convertor.stringToInt(inputView.inputPurchasePrice()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPurchasePrice();
        }
    }

    private LottoAmount calculateLottoAmount(final PurchasePrice purchasePrice) {
        return new LottoAmount(purchasePrice.get());
    }

    private void printLottoAmount(final LottoAmount lottoAmount) {
        outputView.printBuyLotto(lottoAmount.get());
    }

    private LottoNumber createLottoNumber(final LottoAmount lottoAmount, final RandomNumber randomNumber) {
        final LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.add(lottoAmount, randomNumber);
        return lottoNumber;
    }

    private void printLottoNumber(final LottoNumber lottoNumber) {
        outputView.printLottoNumber(lottoNumber.get());
    }

    private Lotto initUserNumbers() {
        try {
            String[] input = Splitter.split(inputView.inputUserLottoNumbers());
            Convertor.validateNull(input);
            Convertor.validateNumberFormat(input);
            return new Lotto(Sorter.ascendingOrder(Convertor.arrayToList(input)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initUserNumbers();
        }
    }

    private BonusNumber initBonusNumber(final Lotto lotto) {
        try {
            return new BonusNumber(lotto.get(), Convertor.stringToInt(inputView.inputBonusNumber()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initBonusNumber(lotto);
        }
    }

    private void printMatchResult(final MatchNumbers matchNumbers) {
        outputView.printMatchNumbers(
                matchNumbers.getThreeMatch(),
                matchNumbers.getFourMatch(),
                matchNumbers.getFiveMatch(),
                matchNumbers.getFiveAndBonusMatch(),
                matchNumbers.getSixMatch()
        );
    }

    private Profit createProfit(final PurchasePrice purchasePrice) {
        return new Profit(purchasePrice.get());
    }

    private void calculateProfit(final Profit profit, final MatchNumbers matchNumbers) {
        profit.calculateTotalPrize(matchNumbers);
        profit.calculateRate();
    }

    private void printProfit(final Profit profit) {
        outputView.printProfit(profit.getRate());
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
        matchNumbers.calculate(lottoNumber.get(), lotto.get(), bonusNumber.get());
        printMatchResult(matchNumbers);

        Profit profit = createProfit(purchasePrice);
        calculateProfit(profit, matchNumbers);
        printProfit(profit);

        inputView.close();
    }
}