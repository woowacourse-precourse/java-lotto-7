package lotto.controller;

import static lotto.view.Prompt.BONUS_NUMBER;
import static lotto.view.Prompt.PURCHASE_AMOUNT;
import static lotto.view.Prompt.WINNING_NUMBERS;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        OutputView.displayPrompt(PURCHASE_AMOUNT);
        String purchaseAmount = InputView.getInput();
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        String formattedLottoNumbers = lottoService.getFormattedLottoNumbers(lottos);
        OutputView.displayLottoNumber(lottos.size(), formattedLottoNumbers);

        OutputView.displayPrompt(WINNING_NUMBERS);
        String winningNumbers = InputView.getInput();

        OutputView.displayPrompt(BONUS_NUMBER);
        String bonusNumber = InputView.getInput();

        Map<Integer, Integer> matchCounts = lottoService.winningDetermination(winningNumbers, bonusNumber, lottos);
        OutputView.displayWinningResult(matchCounts);

        double yield = lottoService.calculateYield(matchCounts, purchaseAmount);
    }
}
