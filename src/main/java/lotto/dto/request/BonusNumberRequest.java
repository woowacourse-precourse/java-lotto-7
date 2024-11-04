package lotto.dto.request;

import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER;

public record BonusNumberRequest(int bonusNumber) {

    public static BonusNumberRequest from(String input) {
        try {
            return new BonusNumberRequest(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }
}
