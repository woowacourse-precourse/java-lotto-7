package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;

public class ConsoleInput implements Input {

    @Override
    public BigInteger inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        if (isInvalidAmount(input)) {
            throw new IllegalArgumentException("금액 입력이 올바르지 않습니다.");
        }
        return new BigInteger(input);
    }

    private boolean isInvalidAmount(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        try {
            new BigInteger(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
