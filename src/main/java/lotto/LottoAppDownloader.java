package lotto;

import lotto.controller.LottoAppController;
import lotto.model.lotto.LottoChecker;
import lotto.model.lotto.LottoPublisher;
import lotto.model.number_generator.LottoNumberGenerator;
import lotto.model.number_generator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoAppDownloader {

    static LottoApp downLoadLottoApp() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPublisher lottoPublisher = makeLottoPublisher();
        LottoChecker lottoChecker = new LottoChecker();
        LottoAppController lottoAppController = new LottoAppController(inputView, outputView, lottoChecker, lottoPublisher);
        return new LottoApp(lottoAppController);
    }

    private static LottoPublisher makeLottoPublisher() {
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return new LottoPublisher(lottoNumberGenerator);
    }
}
