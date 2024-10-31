package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class AmountValidator {
    // private 생성자: 클래스 인스턴스화 방지
    private static final String ERROR_MESSAGE = "[ERROR]";

    private AmountValidator() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int isNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
        }
    }

    public static List<Integer> isNumber(String[] input) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String winningNumber : input) {
                winningNumbers.add(Integer.parseInt(winningNumber));
            }
            return winningNumbers;


        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
        }
    }


    public static void checkAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 음수가 될 수 없습니다.");
        }
        if (amount == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력 금액이 0원입니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 1,000원 단위여야 합니다.");
        }
    }

}

