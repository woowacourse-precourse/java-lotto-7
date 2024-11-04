package lotto;

import lotto.constant.LottoRange;
import lotto.utils.Parser;

import java.util.List;

import static lotto.constant.ErrorMessage.NUMBERS_RANGE_ERROR;

public class BonusNumber {
    private Integer bonusNumber;

    public BonusNumber(String number) {
        Integer bonusNumber = parseNumber(number);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private Integer parseNumber(String number) {
        return Parser.parse(number);
    }

    private void validate(Integer bonusNumber) {
        validateLottoRange(bonusNumber);
    }

    private void validateLottoRange(Integer bonusNumber) {
        if (!LottoRange.isAvailableRange(bonusNumber)) {
            throw new IllegalArgumentException(NUMBERS_RANGE_ERROR.getMessage());
        }
    }
}
