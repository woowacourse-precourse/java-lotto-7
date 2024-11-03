package lotto.console;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.enums.ErrorType;
import lotto.exception.CheckInput;

public class InputConsole {

    public static int intputMoney() {
        System.out.println("구매금액을 입력해 주세요.");

        int inputMoney = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                inputMoney = Integer.parseInt(readLine());
                isValid = CheckInput.checkInputMoney(inputMoney);
            } catch (NumberFormatException e) {
                System.out.println(ErrorType.INVALID_PRICE_FORMAT.getErrorMessage());
                System.out.println("구매금액을 다시 입력해 주세요.");
            }
        }

        return inputMoney;
    }

}