package lotto;

import lotto.controller.lotto.LottoController;
import lotto.io.lotto.LottoInputView;
import lotto.io.lotto.LottoOutputView;
import lotto.service.lotto.LottoService;
import lotto.validator.lotto.LottoValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoInputView lottoInputView = new LottoInputView(new LottoOutputView());
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoService lottoService = new LottoService();
        LottoValidator lottoValidator = new LottoValidator();
        LottoController lottoController = new LottoController(lottoInputView, lottoOutputView, lottoService,
                lottoValidator);
        lottoController.startProgram();
    }
}
