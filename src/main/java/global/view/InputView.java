package global.view;

import static global.utils.Validator.validatePurchaseAmount;
import static lotto.constant.LottoInfoMsg.INPUT_BONUS_NUMBER;
import static lotto.constant.LottoInfoMsg.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.LottoInfoMsg.INPUT_WEEKLY_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMsg());
        return Console.readLine();
    }

    public static String inputWeeklyNumbers() {
        System.out.println(INPUT_WEEKLY_NUMBERS.getMsg());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMsg());
        return Console.readLine();
    }
}
