package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoResultService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoResultService lottoResultService = new LottoResultService();
        LottoValidator lottoValidator = new LottoValidator(new DefaultRangeValidator(), new DefaultDuplicateValidator());
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator(new DefaultRangeValidator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(
            lottoResultService,
            lottoValidator,
            bonusNumberValidator,
            inputView,
            outputView
        );

        lottoController.setUp();
        lottoController.run();
    }
}
