package lotto.util.io;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String NUMBER_DELIMITER = ",";

    public static int parseInputToMoney(String moneyInput) {
        int money;

        try {
            money = Integer.parseInt(moneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 구매 금액은 정수여야 합니다.");
        }

        return money;
    }

    public static List<Integer> parseInputToNumbers(String winningNumberInput) {
        List<Integer> numbers;

        try {
            numbers = Arrays.stream(winningNumberInput.split(NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 로또 번호 입력은 정수와 ','로 이루어져야 합니다.");
        }

        return numbers;
    }

    public static int parseInputToNumber(String numberInput) {
        int number;

        try {
            number = Integer.parseInt(numberInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 정수여야 합니다.");
        }

        return number;
    }
}
