package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.validation.InputValidator;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final InputValidator inputValidator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView,
                           InputValidator inputValidator, LottoService lottoService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.inputValidator = inputValidator;
        this.lottoService = lottoService;
    }

    public void executeLottoPurchase() {
        while (true) {
            try {
                List<Lotto> lottos = lottoService.generateLottos(inputValidator.validate(inputView.userInput()));
                resultView.displayLottos(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Integer> winningNumbers = inputView.lottoWinningNumbers();
        int bonusNumber = inputView.bonusNumber();
    }
}
