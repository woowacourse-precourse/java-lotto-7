package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public static String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String getWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String[] split(String input) {
        return input.split(",");
    }

    public static String[] validateIsNumber(String[] strings) {
        try {
            for (String string : strings) {
                Integer.parseInt(string);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
        return strings;
    }

    public static List<Integer> toInt(String[] strings) {
        List<Integer> integers = new ArrayList<>();
        for (String string : strings) {
            integers.add(Integer.parseInt(string));
        }
        return integers;
    }

    public static String validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다.");
        }
        return input;
    }

    public static String validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        return input;
    }

    public static int validateDivisibleByThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
