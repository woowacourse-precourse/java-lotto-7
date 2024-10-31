package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.impl.LottoServiceImpl;
import lotto.view.input.LottoInputView;
import lotto.view.output.LottoOutputView;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        LottoController controller = init();
        List<Lotto> lottoBundle = controller.purchaseLotto();


    }

    public static LottoController init() {
        LottoInputView providerInputView = new LottoInputView();
        LottoOutputView providerOutputView = new LottoOutputView();
        LottoService lottoService = new LottoServiceImpl();

        return new LottoController(providerInputView, providerOutputView, lottoService);
    }
}