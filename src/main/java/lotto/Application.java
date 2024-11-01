package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService(new LottoNumberGenerator());
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoService, lottoView);

        lottoController.run();
    }

}
