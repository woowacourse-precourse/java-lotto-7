package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    public static int insertMoney() {
        String inputMoney = Console.readLine();
        validateNumber(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> insertWinningNumbers() {
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers) {
            validateNumber(number);
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public static Integer insertBonusNumber() {
        String inputNumber = Console.readLine();
        validateNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력할 수 있습니다.");
        }
    }
}
