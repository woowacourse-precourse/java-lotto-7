package lotto.application;

import lotto.application.controller.LottoController;
import lotto.application.service.LottoService;
import lotto.application.service.utils.RandomNumberGenerator;
import lotto.application.view.input.InputView;
import lotto.application.view.input.InputViewImpl;
import lotto.application.view.output.OutputView;
import lotto.application.view.output.OutputViewImpl;

public class LottoApplication {

  public void run() {
    LottoService lottoService = new LottoService(new RandomNumberGenerator());
    InputView inputView = new InputViewImpl();
    OutputView outputView = new OutputViewImpl();
    LottoController lottoController = new LottoController(lottoService, inputView, outputView);
    lottoController.purchase();
  }
}
