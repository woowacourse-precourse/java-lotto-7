package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoInputMessage;

public class InputView {

    public String inputMoney() {
        System.out.println(LottoInputMessage.INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String inputWinnerNumbers() {
        System.out.println();
        System.out.println(LottoInputMessage.INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(LottoInputMessage.INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
