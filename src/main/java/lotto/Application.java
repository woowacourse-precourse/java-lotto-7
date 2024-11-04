package lotto;

import lotto.controller.LottoController;
import lotto.converter.LottoConverter;
import lotto.service.InputProcessService;
import lotto.service.LottoService;
import lotto.service.OutputProcessService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputView lottoInputView = new LottoInputView();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoConverter lottoConverter = new LottoConverter();
        LottoController lottoController = new LottoController(
                lottoInputView,
                lottoOutputView,
                new OutputProcessService(lottoOutputView, lottoConverter));

        lottoController.start();
    }
}
