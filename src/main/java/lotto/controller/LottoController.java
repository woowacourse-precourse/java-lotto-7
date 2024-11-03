package lotto.controller;

import lotto.lottos.Lottos;
import lotto.calculator.LottoRateCalculator;
import lotto.calculator.LottoResultCalculator;
import lotto.input.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final Lottos lottos = new Lottos();
    final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
    final LottoRateCalculator lottoRateCalculator = new LottoRateCalculator();
    final LottoPriceValidator lottoPriceValidator = new LottoPriceValidator();
    final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();

    private LottoCount lottoCount;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public void start() {
        purchaseLottos();
        createLottos();
        makeWinningNumbers();
        makeBonusNumber();
        calculateResults();
        displayResults();
    }

    private void purchaseLottos() {
        while (true) {
            outputView.printPurchaseGuide();
            String inputPrice = inputView.getPurchasePrice();
            String checkPrice = lottoPriceValidator.validate(inputPrice);
            if (!isInputError(inputPrice, checkPrice)) {
                lottoCount = new LottoCount(inputPrice);
                break;
            }
            outputView.printErrorMessage(checkPrice);
            outputView.printRetryGuide();
        }
        outputView.printLottoCount(lottoCount.get());
    }

    private static boolean isInputError(String input, String checkInput) {
        return input != checkInput;
    }

    private void createLottos() {
        lottos.createLottos(lottoCount.get());
        outputView.printLottos(lottos.get());
    }

    private void makeWinningNumbers() {
        while (true) {
            outputView.printWinningNumbersGuide();
            String inputWinningNumbers = inputView.getWinningNumbers();
            String checkWinningNumbers = winningNumbersValidator.validate(inputWinningNumbers);
            if (!isInputError(inputWinningNumbers, checkWinningNumbers)) {
                winningNumbers = new WinningNumbers(inputWinningNumbers);
                break;
            }
            outputView.printErrorMessage(checkWinningNumbers);
            outputView.printRetryGuide();
        }
    }

    private void makeBonusNumber() {
        while (true) {
            outputView.printBonusNumberGuide();
            String inputBonusNumber = inputView.getBonusNumber();
            String checkBonusNumber = bonusNumberValidator.validate(inputBonusNumber, winningNumbers.get());
            if (!isInputError(inputBonusNumber, checkBonusNumber)) {
                bonusNumber = new BonusNumber(inputBonusNumber);
                break;
            }
            outputView.printErrorMessage(checkBonusNumber);
            outputView.printRetryGuide();
        }
    }

    private void calculateResults() {
        lottoResultCalculator.calculate(winningNumbers.get(), bonusNumber.get(), lottos.get());
        int price = lottoCount.get() * LOTTO_PRICE;
        lottoRateCalculator.calculate(price, lottoResultCalculator.getResult());
    }

    private void displayResults() {
        outputView.printLottoResult(lottoResultCalculator.getResult());
        outputView.printLottoRate(lottoRateCalculator.getRate());
    }
}
