package lotto.message;

import java.text.NumberFormat;

public enum ErrorMessage {

    NON_INTEGER_PURCHASE_AMOUNT("구입 금액은 정수여야 합니다."),
    NEGATIVE_PURCHASE_AMOUNT("구입 금액은 {}원 이상이어야 합니다."),
    OVERFLOW_PURCHASE_AMOUNT("구입 금액은 {}원 이하여야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 {}원으로 나누어 떨어져야 합니다."),
    LOTTO_SIZE_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("6개의 로또 번호는 중복될 수 없습니다."),
    NON_INTEGER_LOTTO("로또 번호는 정수여야 합니다."),
    LOTTO_SCOPE_ERROR("로또 번호는 1 이상 45 이하의 정수여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 6개의 당첨 번호와 중복될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }

    public String formatCost(int cost){
        String formattedNumber = NumberFormat.getInstance().format(cost);
        return message.replace("{}", formattedNumber);
    }
}
