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
    private final GameService gameService = new GameService();
    private final Validator validator = new Validator();

    public void lottoGameStart() {

        Money money = gameService.createMoney(getPurchaseMoney());

        LotteryMachine lotteryMachine = gameService.purchaseLotto(money);
        OutputView.printPurchaseLotto(lotteryMachine);

        InputView.requestWinningNumber();
        List<Integer> winningNumbers = getWinningNumbers();
        InputView.requestBonusNumber();
        int bonusBall = getBonusBall();

        LottoResultChecker lottoResultChecker = gameService.lottoResult(winningNumbers, bonusBall, lotteryMachine);
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
        String winningNumber = Console.readLine();
        return validator.validateIsNumeric(winningNumber);
    }

    public int getBonusBall() {
        String bonusBall = Console.readLine();
        return validator.validateConvertToNumber(bonusBall);
    }

}
