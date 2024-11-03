package lotto.view;

import static lotto.constant.LottoInputMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.LottoInputMessage.INPUT_MONEY_MESSAGE;
import static lotto.constant.LottoInputMessage.INPUT_WINNING_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String inputWinnerNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
