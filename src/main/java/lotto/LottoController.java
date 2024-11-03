package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final int lottoPrice = 1000;
    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    final Lottos lottos = new Lottos();
    final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
    final LottoRateCalculator lottoRateCalculator = new LottoRateCalculator();
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public void start() {
        int lottoCount = purchaseLottos();
        createLottos(lottoCount);
        makeWinningNumbers();
        calculateResults(lottoCount * lottoPrice);
        displayResults();
    }

    private void makeWinningNumbers() {
        outputView.printWinningNumbersGuide();
        winningNumbers = new WinningNumbers(inputView.getWinningNumbers());
        outputView.printBonusNumberGuide();
        bonusNumber = new BonusNumber(inputView.getBonusNumber(), winningNumbers.get());
    }

    private int purchaseLottos() {
        int lottoCount = 0;
        while (true) {
            outputView.printPurchaseGuide();
            String price = inputView.getPurchasePrice();
            LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(price);
            lottoCount = lottoPurchaseService.getLottoCount();
            if (!isPriceInputError(price, lottoPurchaseService.getPrice())) {
                break;
            }
            outputView.printErrorMessage(lottoPurchaseService.getPrice());
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
