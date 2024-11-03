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

    public void start() {
        int lottoCount = purchaseLottos();
        playLotto(lottoCount);
        calculateResults(lottoCount * lottoPrice);
        displayResults();
    }

    private int purchaseLottos() {
        int lottoCount = 0;
        while (true) {
            outputView.printPurchaseGuide();
            String price = inputView.getPurchasePrice();
            LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(price);
            lottoCount = lottoPurchaseService.getLottoCount();
            if (!isError(lottoCount)) {
                break;
            }
            outputView.printRetryGuide();
        }
        outputView.printLottoCount(lottoCount);
        return lottoCount;
    }

    private static boolean isError(int lottoCount) {
        return lottoCount < 1;
    }

    private void playLotto(int lottoCount) {
        lottos.createLottos(lottoCount);
        outputView.printLottos(lottos.getLottos());
        outputView.printWinningNumbersGuide();
        String winningNumber = inputView.getWinningNumbers();
        outputView.printBonusNumberGuide();
        String bonusNumber = inputView.getBonusNumber();
        winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
    }

    private void calculateResults(int price) {
        lottoResultCalculator.calculate(winningNumbers, lottos.getLottos());
        lottoRateCalculator.calculate(price, lottoResultCalculator.getResult());
    }

    private void displayResults() {
        outputView.printLottoResult(lottoResultCalculator.getResult());
        outputView.printLottoRate(lottoRateCalculator.getRate());
    }

}
