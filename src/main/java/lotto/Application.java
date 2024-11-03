package lotto;

import lotto.controller.LottoController;
import lotto.repository.LottoRepositoryImpl;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {

    private static final LottoInputView lottoInputView = new LottoInputView();
    private static final LottoOutputView lottoOutputView = new LottoOutputView();
    private static final LottoRepositoryImpl lottoRepository = new LottoRepositoryImpl();
    private static final LottoService lottoService = new LottoService(lottoRepository);
    private static final LottoController lottoController = new LottoController(lottoInputView, lottoOutputView, lottoService);

    public static void main(String[] args) {
        lottoController.payingForLotto();
    }
}
