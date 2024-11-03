package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String value = Console.readLine();
        validateEmpty(value);
        validateNumber(value);
        int amount = Integer.parseInt(value);
        validateUnit(amount);
        return amount;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateEmpty(input);
        List<String> values = Utils.splitNumbers(input);
        return Utils.convertNumbers(values);
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이 입력되었습니다.");
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    private static void validateUnit(int amount) {
        if ((amount % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
        }
    }
}
