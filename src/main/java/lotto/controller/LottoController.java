package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.model.LottoRank;
import lotto.model.LottoRevenueCalculator;
import lotto.model.LottoWinningChecker;
import lotto.model.PurchasedLottos;
import lotto.model.WinningLotto;
import lotto.util.NumbersGenerator;
import lotto.validator.MoneyValidator;
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

        Map<LottoRank, Integer> lottoResult = getLottoResult(purchasedLottos, winningLotto);
        outputView.showLottoResult(lottoResult);

        double revenue = calculateLottoRevenue(lottoResult, purchaseMoney);
        outputView.showLottoRevenue(revenue);
    }

    private int getMoney() {
        while (true) {
            try {
                int money = getMoneyFromUser();
                MoneyValidator moneyValidator = new MoneyValidator();
                moneyValidator.validateMoney(money);
                return money;

            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private int getMoneyFromUser() {
        outputView.showMoneyInputComments();
        return inputView.getMoneyFromUser();
    }

    private static int calculatePurchaseCountBy(int money) {
        return money / LottoConstants.LOTTO_PRICE.getValue();
    }

    private Lotto getLottoWinningNumbers() {
        while (true) {
            try {
                List<Integer> lottoWinningNumbers = getWinningNumberFromUser();
                return Lotto.of(lottoWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private List<Integer> getWinningNumberFromUser() {
        outputView.showLottoWinningNumbersInputComments();
        return inputView.getLottoWinningNumbersFromUser();
    }

    private int getLottoBonusNumber() {
        while (true) {
            try {
                return getLottoBonusNumberFromUser();
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private int getLottoBonusNumberFromUser() {
        outputView.showLottoBonusNumberInputComments();
        return inputView.getLottoBonusNumberFromUser();
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

    private Map<LottoRank, Integer> getLottoResult(PurchasedLottos purchasedLottos,
                                                   WinningLotto winningLotto) {
        LottoWinningChecker lottoWinningChecker = LottoWinningChecker.of(purchasedLottos, winningLotto);
        return lottoWinningChecker.getLottoWinningResult();
    }

    private double calculateLottoRevenue(Map<LottoRank, Integer> lottoResult, int purchaseMoney) {
        LottoRevenueCalculator lottoRevenueCalculator = LottoRevenueCalculator.of(lottoResult, purchaseMoney);
        return lottoRevenueCalculator.calculateRevenue();
    }
}
