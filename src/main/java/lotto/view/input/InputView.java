package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputMoney() {
        System.out.println(InputViewMessage.INPUT_MONEY_VIEW);
        return Console.readLine();
    }

    public static String inputLottoNumbers() {
        System.out.println(InputViewMessage.INPUT_WINNING_NUMBER_VIEW);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(InputViewMessage.INPUT_BONUS_NUMBER_VIEW);
        return Console.readLine();
    }
}
