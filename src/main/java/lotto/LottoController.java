package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final Lottos lottos = new Lottos();
    final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
    final LottoRateCalculator lottoRateCalculator = new LottoRateCalculator();
    final LottoPriceValidator lottoPriceValidator = new LottoPriceValidator();
    final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    private int lottoCount;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public void start() {
        int lottoCount = purchaseLottos();
        createLottos(lottoCount);
        makeWinningNumbers();
        makeBonusNumber(winningNumbers.get());
        calculateResults(lottoCount * LOTTO_PRICE);
        displayResults();
    }

    private void makeWinningNumbers() {
        outputView.printWinningNumbersGuide();
        winningNumbers = new WinningNumbers(inputView.getWinningNumbers());
    }

    private void makeBonusNumber(List<Integer> winnerNumbers) {
        while (true) {
            outputView.printBonusNumberGuide();
            String inputBonusNumber = inputView.getBonusNumber();
            String checkBonusNumber = bonusNumberValidator.validate(inputBonusNumber, winnerNumbers);

            if (!isPriceInputError(inputBonusNumber, checkBonusNumber)) {
                bonusNumber = new BonusNumber(inputBonusNumber);
                break;
            }

            outputView.printErrorMessage(checkBonusNumber);
            outputView.printRetryGuide();
        }
    }

    private int purchaseLottos() {
        lottoCount = 0;
        while (true) {
            outputView.printPurchaseGuide();
            String price = inputView.getPurchasePrice();
            String checkPrice = lottoPriceValidator.validate(price);

            if (!isPriceInputError(price, checkPrice)) {
                lottoCount = Integer.parseInt(price) / LOTTO_PRICE;
                break;
            }

            outputView.printErrorMessage(checkPrice);
            outputView.printRetryGuide();
        }
        outputView.printLottoCount(lottoCount);
        return lottoCount;
    }

    private static boolean isPriceInputError(String price, String checkPrice) {
        return price != checkPrice;
    }

    private void createLottos(int lottoCount) {
        lottos.createLottos(lottoCount);
        outputView.printLottos(lottos.get());
    }

    private void calculateResults(int price) {
        lottoResultCalculator.calculate(winningNumbers.get(), bonusNumber.get(), lottos.get());
        lottoRateCalculator.calculate(price, lottoResultCalculator.getResult());
    }

    private void displayResults() {
        outputView.printLottoResult(lottoResultCalculator.getResult());
        outputView.printLottoRate(lottoRateCalculator.getRate());
    }
}
