package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Constants;


public class InputView {

    public String inputLottoCost() {

        System.out.println(Constants.LOTTO_COST_INPUT);
        String lottoCost = Console.readLine();
        System.out.println();

        return lottoCost;
    }

    public String inputWinningNumbers() {

        System.out.println(Constants.WINNING_LOTTO_INPUT);
        String winningNumbers = Console.readLine();
        System.out.println();

        return winningNumbers;
    }

    public String inputLottoBonusNumber() {

        System.out.println(Constants.BONUS_NUMBER_INPUT);
        String bonusNumber = Console.readLine();
        System.out.println();

        return bonusNumber;
    }
}
