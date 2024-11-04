package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {
    private final int amount;

    public Money(String input) {
        long parsedAmount  = parseInput(input);  // 입력값의 int 범위 초과 검증을 위해 우선 long 으로 변환
        MoneyValidator.validate(parsedAmount);
        this.amount = (int) parsedAmount ;
    }

    private long parseInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 필수 입력 항목입니다.");
        }
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}
