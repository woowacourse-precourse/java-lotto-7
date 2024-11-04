package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottosServiceInterface;
import lotto.validator.InputValidator;
import lotto.validator.InputValidatorInterface;
import lotto.view.InputView;
import lotto.view.InputViewInterface;
import lotto.view.OutputView;
import lotto.view.OutputViewInterface;

public class Application {

  public static void main(String[] args) {
    LottosServiceInterface lottoService = new LottoService();
    InputViewInterface inputView = new InputView();
    OutputViewInterface outputView = new OutputView();
    InputValidatorInterface inputValidator = new InputValidator();

    LottoController controller = new LottoController(inputView, outputView, lottoService,
        inputValidator);

    controller.run();
  }

}