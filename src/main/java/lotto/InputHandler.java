package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

public class InputHandler {
    static final String LOTTO_BUDGET_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int getLottoBudget() {
        System.out.println(LOTTO_BUDGET_INPUT_MESSAGE);
        int budget;
        try {
            budget = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력해야 합니다.");
        }
        validateLottoBudget(budget);
        return budget;
    }

    public static void validateLottoBudget(int budget) {
        if (budget <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
        if (budget % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            List<Integer> winningNumbers = Stream.of(input.split(",", -1))
                    .map(Integer::parseInt)
                    .toList();
            validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표로 입력해야 합니다.");
        }

    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
