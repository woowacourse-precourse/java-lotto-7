package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.LotteryMachine;
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
        int bonusBall = getBonusBall();
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
        InputView.requestWinningNumber();
        String winningNumber = Console.readLine();
        return validator.validateIsNumeric(winningNumber);
    }

    public int getBonusBall() {
        InputView.requestBonusNumber();
        String bonusBall = Console.readLine();
        return validator.validateConvertToNumber(bonusBall);
    }

}
