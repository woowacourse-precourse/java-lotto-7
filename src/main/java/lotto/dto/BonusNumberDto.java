package lotto.dto;

import lotto.utils.LottoUtils;

import static lotto.exception.LottoExceptionStatus.INVALID_BONUS_NUMBER_RANGE;
import static lotto.properties.LottoProperties.LOTTO_NUMBER_END;
import static lotto.properties.LottoProperties.LOTTO_NUMBER_START;

public record BonusNumberDto(
        int bonusNumber
) {

    public BonusNumberDto {
        validate(bonusNumber);
    }

    private void validate(int bonusNumber) {
        isOutOfRange(bonusNumber);
    }

    private void isOutOfRange(int number) {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    public static BonusNumberDto from(String input) {
        return new BonusNumberDto(LottoUtils.checkBonusNumberFormat(input.trim()));
    }
}
