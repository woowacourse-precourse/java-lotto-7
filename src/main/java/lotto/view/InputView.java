package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constants.Constants.*;

public class InputView {

    public static String inputLottoMoney() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String inputLottoNumber() {
        System.out.println();
        System.out.println(INPUT_WiNNiNG_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
