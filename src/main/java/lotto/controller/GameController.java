package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoResultChecker;
import lotto.domain.Money;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final Validator validator = new Validator();

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void lottoGameStart() {
        Money money = gameService.createMoney(getPurchaseMoney());
        LotteryMachine lotteryMachine = purchaseLotto(money);
        LottoResultChecker lottoResultChecker = CheckResult(lotteryMachine);
        displayResult(lottoResultChecker, money);
    }

    private LotteryMachine purchaseLotto(Money money) {
        LotteryMachine lotteryMachine = gameService.purchaseLotto(money);
        OutputView.printPurchaseLotto(lotteryMachine, money);
        return lotteryMachine;
    }

    private LottoResultChecker CheckResult(LotteryMachine lotteryMachine) {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusBall = getBonusBall(winningNumbers);
        return gameService.lottoResult(winningNumbers, bonusBall, lotteryMachine);
    }

    private void displayResult(LottoResultChecker lottoResultChecker, Money money) {
        OutputView.printLottoResult(lottoResultChecker);
        OutputView.printLottoProfit(gameService.calculateProfitRate(lottoResultChecker, money));
    }

    public int getPurchaseMoney() {
        boolean valid = false;
        int money = 0;
        while (!valid) {
            try {
                InputView.requestPurchaseMoney();
                String input = Console.readLine();
                money = validator.validateConvertToNumber(input);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
        return money;
    }

    public List<Integer> getWinningNumbers() {
        boolean valid = false;
        List<Integer> numbers = new ArrayList<>();
        while (!valid) {
            try {
                InputView.requestWinningNumber();
                String winningNumber = Console.readLine();
                numbers = validator.validateIsNumeric(winningNumber);
                validator.validateWinningNumber(new Lotto(numbers));
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
        return numbers;
    }

    public int getBonusBall(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        boolean valid = false;
        while (!valid) {
            try {
                InputView.requestBonusNumber();
                String bonusBall = Console.readLine();
                bonusNumber = validator.validateConvertToNumber(bonusBall);
                validator.validateBonusNumber(winningNumbers, bonusNumber);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
        return bonusNumber;
    }

}
