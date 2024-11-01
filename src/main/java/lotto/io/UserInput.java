package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoShop;

public class UserInput {
    private static final String SEPARATOR = ",";

    public int getPurchaseAmount() {
        String input = Console.readLine().trim();
        validateEmptyInput(input);
        return LottoShop.validatePurchaseAmount(input);
    }

    public void getWinningNumbers() {
        String input = Console.readLine().trim();
        validateEmptyInput(input);
        validateContainsSeparator(input);
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열은 입력할 수 없습니다");
        }
    }

    private void validateContainsSeparator(String input) {
        if (hasNotSeparator(input)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 포함해야 합니다");
        }
    }

    private static boolean hasNotSeparator(String input) {
        return !input.contains(SEPARATOR);
    }

}
