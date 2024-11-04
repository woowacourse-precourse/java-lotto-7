package lotto;

import camp.nextstep.edu.missionutils.Console;

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
}
