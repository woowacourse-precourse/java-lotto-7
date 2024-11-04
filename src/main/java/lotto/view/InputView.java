package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String FORMAT_ERROR_MESSAGE = ERROR_MESSAGE + "숫자만 입력해 주세요.";

    public Money inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        try {
            return Money.from(inputNumberToInt());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private int inputNumberToInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(FORMAT_ERROR_MESSAGE);
            return inputNumberToInt();
        }
    }
}
