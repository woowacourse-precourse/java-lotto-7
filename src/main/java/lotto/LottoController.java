package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public LottoController() {
    }

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        outputView.printInputCashMessage();
        String input = inputView.inputCash();
        Integer lottoAmount = LottoUtils.convertInputToCash(input);

        List<Lotto> lottos = lottoService.getLotto(lottoAmount);
        outputView.printLottoAmount(lottoAmount);
        outputView.printLottos(lottos);

        outputView.printInputWinningNumber();
        String winningNumbers = inputView.inputWinningNumber();
        Lotto winningLotto = parseWinningNumber(winningNumbers);

        outputView.printInputBonusNumber();
        String inputBonusNumber = inputView.inputBonusNumber();
        Integer bonusNumber = parseBonusNumber(inputBonusNumber);

    }

    private Lotto parseWinningNumber(String input) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] numbers = input.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        Lotto winningLotto = new Lotto(winningNumbers);

        return winningLotto;
    }

    private Integer parseBonusNumber(String input) {
        if (!LottoUtils.isNumber(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }
}
