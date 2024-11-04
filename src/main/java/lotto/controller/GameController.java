package lotto.controller;

import static lotto.view.InputView.getBonusNumber;
import static lotto.view.InputView.getPurchaseStr;
import static lotto.view.InputView.getWinningNumStr;
import static lotto.view.OutputView.printLottosNum;
import static lotto.view.OutputView.printRateOfReturn;
import static lotto.view.OutputView.printResult;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.service.GameService;
import lotto.util.InputParser;
import lotto.util.InputValidator;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        Lotto winningLotto = new Lotto(getValidWinningNumbers());
        int bonusNumber = getValidBonusNumber(winningLotto);

        List<Lotto> lottos = gameService.generateLottos(purchaseAmount);
        Game game = gameService.createGame(lottos, winningLotto, bonusNumber);

        displayResults(game, purchaseAmount, winningLotto, lottos);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                int amount = InputParser.parseInteger(getPurchaseStr());
                InputValidator.validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                return InputParser.parseWinningNumbers(getWinningNumStr());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }

    private int getValidBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                int bonus = InputParser.parseInteger(getBonusNumber());
                InputValidator.validateRange(bonus);
                InputValidator.validateDuplicate(winningLotto, bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }

    private void displayResults(Game game, int purchaseAmount, Lotto winningLotto, List<Lotto> lottos) {
        int[] results = gameService.getResults(game, winningLotto);
        double rateOfReturn = gameService.calculateRateOfReturn(game, purchaseAmount, results);

        printLottosNum(lottos);
        System.out.println();
        printResult(results);
        System.out.println();
        printRateOfReturn(rateOfReturn);
    }
}
