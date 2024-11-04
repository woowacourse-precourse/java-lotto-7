package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto.LottoNumbersGenerator;
import lotto.formatter.LottoFormatter;
import lotto.domain.WinningLotto.WinningLottoCalculate;
import lotto.domain.WinningLotto.WinningLottoCounter;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController createLottoController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoValidator lottoValidator = new LottoValidator();
        WinningLottoCounter winningLottoCounter = new WinningLottoCounter();
        LottoFormatter lottoFormatter = new LottoFormatter(winningLottoCounter);
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(lottoValidator);
        LottoManager lottoManager = new LottoManager(lottoNumbersGenerator);
        WinningLottoCalculate winningLottoCalculate = new WinningLottoCalculate(winningLottoCounter, lottoFormatter);
        LottoService lottoService = new LottoService(lottoManager, lottoFormatter, winningLottoCounter, winningLottoCalculate, lottoValidator);
        return new LottoController(inputView, outputView, lottoService);
    }
}
