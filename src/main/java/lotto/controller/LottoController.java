package lotto.controller;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.model.LottoRank;
import lotto.model.LottoResultChecker;
import lotto.model.LottoRevenueCalculator;
import lotto.model.PurchasedLottos;
import lotto.model.WinningLotto;
import lotto.util.NumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumbersGenerator numbersGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumbersGenerator numbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numbersGenerator = numbersGenerator;
    }

    public void run() {
        int purchaseMoney = getMoney();
        int purchaseCount = calculatePurchaseCountBy(purchaseMoney);

        PurchasedLottos purchasedLottos = PurchasedLottos.purchase(purchaseCount, numbersGenerator);
        outputView.showPurchasedLottos(purchaseCount, purchasedLottos);

        WinningLotto winningLotto = getWinningLotto();

        Map<LottoRank, Integer> lottoResult = LottoResultChecker.lottoResultFrom(purchasedLottos, winningLotto);
        outputView.showLottoResult(lottoResult);

        double revenue = calculateLottoRevenue(lottoResult, purchaseMoney);
        outputView.showLottoRevenue(revenue);
    }

    private int getMoney() {
        while (true) {
            try {
                outputView.showMoneyInputComments();
                return inputView.getMoneyFromUser();

            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private static int calculatePurchaseCountBy(int money) {
        return money / LottoConstants.LOTTO_PRICE.getValue();
    }

    private Lotto getLottoWinningNumbers() {
        while (true) {
            try {
                outputView.showLottoWinningNumbersInputComments();
                return inputView.getLottoWinningNumbersFromUser();
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private int getLottoBonusNumber() {
        while (true) {
            try {
                outputView.showLottoBonusNumberInputComments();
                return inputView.getLottoBonusNumberFromUser();
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private WinningLotto createWinningLottoNumbers(Lotto lottoWinningNumbers, int lottoBonusNumber) {
        while (true) {
            try {
                return WinningLotto.of(lottoWinningNumbers, lottoBonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
                lottoBonusNumber = getLottoBonusNumber();
            }
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto lottoWinningNumbers = getLottoWinningNumbers();
        int lottoBonusNumber = getLottoBonusNumber();
        return createWinningLottoNumbers(lottoWinningNumbers, lottoBonusNumber);
    }

    private double calculateLottoRevenue(Map<LottoRank, Integer> lottoResult, int purchaseMoney) {
        LottoRevenueCalculator lottoRevenueCalculator = LottoRevenueCalculator.of(lottoResult, purchaseMoney);
        return lottoRevenueCalculator.calculateRevenue();
    }
}
