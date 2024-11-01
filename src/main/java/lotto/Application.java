package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.service.InputParsingService;
import lotto.service.InputValidationService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidationService inputValidationService = new InputValidationService();
        InputParsingService inputParsingService = new InputParsingService();

        LottoController lottoController =
                new LottoController(inputView, outputView, inputValidationService, inputParsingService);
        lottoController.runLotto();

        Console.close();
    }
}
