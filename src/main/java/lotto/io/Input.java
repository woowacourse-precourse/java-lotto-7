package lotto.io;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Input implements AutoCloseable {

    public static int readMoney() {
        String money = Console.readLine();

        validateNumber(money);

        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("1000단위만 입력이 가능합니다.");
        }

        return Integer.parseInt(money);
    }

    public static List<Integer> readWinningNumber() {
        String winningNumber = Console.readLine();

        if (!Pattern.matches("^[1-9|,]+$", winningNumber)) {
            throw new IllegalArgumentException("입력은 숫자와 컴마만 가능합니다.");
        }

        if (winningNumber.startsWith(",") && winningNumber.endsWith(",")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }

        List<Integer> numbers = Arrays
                .stream(winningNumber.trim().split(","))
                .map(Integer::valueOf)
                .distinct()
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 6글자를 입력해주세요. (중복은 허용되지 않습니다.)");
        }

        return numbers;
    }

    public static int readBonusNumber() {
        String bonusNumber = Console.readLine();
        validateNumber(bonusNumber);

        if (Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("45 이상을 입력할 수 없습니다.");
        }

        return Integer.parseInt(bonusNumber);
    }

    private static void validateNumber(String input) {
        boolean isNotNumber = !Pattern.matches("[0-9]+", input);
        if (isNotNumber) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    @Override
    public void close() throws Exception {
        Console.close();
    }
}
