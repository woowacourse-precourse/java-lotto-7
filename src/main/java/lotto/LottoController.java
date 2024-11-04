package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public LottoController() {
    }

    public void run() {
        outputView.printInputCashMessage();
        String input = inputView.inputCash();
        Integer lottoAmount = lottoService.convertInputToCash(input);

        List<Lotto> lottos = lottoService.getLotto(lottoAmount);
        outputView.printLottoAmountMessage(lottoAmount);
        outputView.printLottos(lottos);

        outputView.printInputWinningNumberMessage();
        String winningNumbers = inputView.inputWinningNumber();
        Lotto winningLotto = lottoService.parseWinningNumber(winningNumbers);

        outputView.printInputBonusNumberMessage();
        String inputBonusNumber = inputView.inputBonusNumber();
        Integer bonusNumber = lottoService.parseBonusNumber(inputBonusNumber);
    }
}
