package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    private final Utils utils = new Utils();

    public void run() {
        outputView.printInputCashMessage();
        String input = inputView.inputCash();
        Integer lottoAmount = utils.convertInputToCash(input);

        List<Lotto> lottos = lottoService.getLotto(lottoAmount);
        outputView.printLottoAmount(lottoAmount);
        outputView.printLottos(lottos);
    }
}
