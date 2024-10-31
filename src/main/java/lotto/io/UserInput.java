package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoShop;

public class UserInput {
    public int getPurchaseAmount() {
        String input = Console.readLine().trim();
        validateEmptyInput(input);
        return LottoShop.validatePurchaseAmount(input);
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열은 입력할 수 없습니다");
        }
    }
}
