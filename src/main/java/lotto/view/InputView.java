package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.ErrorMessage;

public class InputView {
    private static final String INPUT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    public int inputMoneyAmount() {
        System.out.println(INPUT_MONEY_AMOUNT);
        while (true) {
            try {
                int input = parseIntInputString();
                validateInputMoney(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected void validateInputMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }
}
