package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    private InputUtil() {}

    public static int insertMoney() {
        String inputMoney = Console.readLine();
        try {
            validateNumber(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자가 아닙니다.");
            insertMoney();
        }
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
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 가능 합니다.");
        }
    }
}
