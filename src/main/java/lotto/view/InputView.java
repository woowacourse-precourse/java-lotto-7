package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.";

    public int lottoMoneyInput() {
        String rawMoney;
        while (true) {
            System.out.println(ASK_MONEY_INPUT);
            rawMoney = Console.readLine();
            try {
                validateIsNumber(rawMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return Integer.parseInt(rawMoney);
        }
    }

    private void validateIsNumber(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_NUMBER.getMsg());
        }
    }
}
