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
                processLottoResults(createLottoGame());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processLottoResults(LottoGame lottoGame) {
        updateLottoGameResults(lottoGame, generateAndDisplayLottos(lottoGame), createWinningLotto());
        resultView.printResult(lottoGame);
    }

    private LottoGame createLottoGame() {
        return new LottoGame(purchaseAmount());
    }

    private int purchaseAmount() {
        while (true) {
            try {
                return validator.validate(inputView.userInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateAndDisplayLottos(LottoGame lottoGame) {
        List<Lotto> purchasedLottos = lottoService.generateLottos(lottoGame.getPurchaseAmount());
        resultView.displayLottos(purchasedLottos);
        return purchasedLottos;
    }

    private void updateLottoGameResults(LottoGame lottoGame, List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        addRanksToGame(lottoGame, determineRanks(purchasedLottos, winningLotto));
    }

    private List<Rank> determineRanks(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        return lottoService.determineWinningRanks(purchasedLottos, winningLotto);
    }

    private void addRanksToGame(LottoGame lottoGame, List<Rank> ranks) {
        ranks.forEach(lottoGame::addResult);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = winningNumbers();
        return new WinningLotto(winningNumbers, bonusNumberFromInput(winningNumbers));
    }

    private List<Integer> winningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.lottoWinningNumbers();
                validator.winningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int  bonusNumberFromInput(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonus = validator.parseInput(inputView.bonusNumber());
                validator.validateBonusNumber(bonus, winningNumbers);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}