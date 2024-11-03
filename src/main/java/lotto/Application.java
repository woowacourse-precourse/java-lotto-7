package lotto;

import lotto.cotroller.LottoController;
import lotto.service.LottoGenerator;
import lotto.service.LottoRevenueCalculator;
import lotto.service.LottoWinningChecker;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputView lottoInputView = new LottoInputView();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker();
        LottoRevenueCalculator lottoRevenueCalculator = new LottoRevenueCalculator();
        LottoController lottoController = new LottoController(lottoInputView, lottoOutputView, lottoGenerator,
                lottoWinningChecker, lottoRevenueCalculator);

        lottoController.run();
    }
}
