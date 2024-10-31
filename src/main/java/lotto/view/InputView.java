package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.";

    public int lottoMoneyInput() {
        System.out.println(ASK_MONEY_INPUT);
        String rawMoney = Console.readLine();

        validateIsNumber(rawMoney);

        return Integer.parseInt(rawMoney);
    }

    private void validateIsNumber(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_NUMBER.getMsg());
        }
    }
}
