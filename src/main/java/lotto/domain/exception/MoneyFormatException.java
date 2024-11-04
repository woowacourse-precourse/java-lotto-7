package lotto.domain.exception;

import lotto.domain.Lotto;

public class MoneyFormatException extends RuntimeException {

    public MoneyFormatException() {
      super();
    }

    public MoneyFormatException(String message) {
        super(message);
    }

    public static MoneyFormatException invalidNumber() {
        return new MoneyFormatException("구입 금액은 숫자로만 이루어져야 합니다.");
    }

    public static MoneyFormatException notDivisible() {
        return new MoneyFormatException(String.format("구입 금액은 %,d원 단위로 나누어 떨어져야 합니다.", Lotto.TICKET_PRICE));
    }

    public static MoneyFormatException notPositive() {
        return new MoneyFormatException("구입 금액은 양수여야 합니다.");
    }
}
