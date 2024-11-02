package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ClientInput {
    public int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return integerValidation(Console.readLine());
    }

    private int integerValidation(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(input);
    }
}
