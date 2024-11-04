package lotto.controller;

import lotto.model.bonusnumber.BonusNumber;
import lotto.model.bonusnumber.BonusNumberValidator;
import lotto.model.lottoprice.LottoPrice;
import lotto.model.lottoprice.LottoPriceValidator;
import lotto.model.winningnumbers.WinningNumbers;
import lotto.model.winningnumbers.WinningNumbersValidator;
import lotto.model.lottos.Lottos;
import lotto.model.calculator.LottoRateCalculator;
import lotto.model.calculator.LottoResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Lottos lottos = new Lottos();
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
    private final LottoRateCalculator lottoRateCalculator = new LottoRateCalculator();
    private final LottoPriceValidator lottoPriceValidator = new LottoPriceValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    private final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();

    private LottoPrice lottoPrice;
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
                lottoPrice = new LottoPrice(inputPrice);
                break;
            }
            outputView.printErrorMessage(checkPrice);
            outputView.printRetryGuide();
        }
        outputView.printLottoCount(lottoPrice.getLottoCount());
    }

    private static boolean isInputError(String input, String checkInput) {
        return input != checkInput;
    }

    private void createLottos() {
        lottos.createLottos(lottoPrice.getLottoCount());
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
        lottoRateCalculator.calculate(lottoPrice.get(), lottoResultCalculator.getResult());
    }

    private void displayResults() {
        outputView.printLottoResult(lottoResultCalculator.getResult());
        outputView.printLottoRate(lottoRateCalculator.getRate());
    }
}
