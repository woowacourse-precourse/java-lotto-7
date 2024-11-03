package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.validation.Validator;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Validator validator;
    private final LottoService lottoService;
    private LottoGame lottoGame;

    public LottoController(InputView inputView, ResultView resultView,
                           Validator validator, LottoService lottoService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.validator = validator;
        this.lottoService = lottoService;
    }

    public void executeLottoPurchase() {
        while (true) {
            try {
                int purchaseAmount = purchaseAmount();
                lottoGame = new LottoGame(purchaseAmount);
                List<Lotto> purchasedLottos = lottoService.generateLottos(purchaseAmount);
                resultView.displayLottos(purchasedLottos);

                WinningLotto winningLotto = createWinningLotto();
                List<Rank> ranks = lottoService.checkWinningLottos(purchasedLottos, winningLotto);

                for (Rank rank : ranks) {
                    lottoGame.addResult(rank);
                }

                resultView.printResult(lottoGame);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int purchaseAmount() {
        return validator.validate(inputView.userInput());
    }

    private WinningLotto createWinningLotto() {
        return new WinningLotto(getWinningNumbers(), getBonusNumber());
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = inputView.lottoWinningNumbers();
        validator.winningNumbers(winningNumbers);
        return winningNumbers;
    }

    private int getBonusNumber() {
        return validator.parseInput(inputView.bonusNumber());
    }
}
