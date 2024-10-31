package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    private static void validateInput(String money) {
        if (!validateNumber(money) || !validateMoney(money)) {
            throw new RuntimeException(ERROR_MESSAGE + " 잘못된 입력 입니다.");
        }
    }

    private static boolean validateNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private static boolean validateMoney(String money) {
        if (Integer.parseInt(money) < 0 || Integer.parseInt(money) % 1000 != 0) {
            return false;
        }
        return true;
    }
}