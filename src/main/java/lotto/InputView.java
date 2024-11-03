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
        return Integer.parseInt(value);
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이 입력되었습니다.");
        }
    }
}
