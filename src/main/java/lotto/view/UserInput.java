package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        isNumber(input);
        validatePositiveAmount(amount);
        validatePurchaseAmount(amount);

        return amount;
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winNumbers = new ArrayList<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            winNumbers.add(num);
        }
        return winNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private static void isNumber(String input) {
        if (input.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
    }
}
