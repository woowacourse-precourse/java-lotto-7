package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    public static String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String getWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
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

    public static List<Integer> validateCount(List<Integer> integers) {
        if (integers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return integers;
    }

    public static List<Integer> validateNotDuplicate(List<Integer> integers) {
        Set<Integer> set = new HashSet<>(integers);
        if (set.size() != integers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
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
