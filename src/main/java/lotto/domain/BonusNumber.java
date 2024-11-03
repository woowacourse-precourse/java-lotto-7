package lotto.domain;

import static lotto.enums.ErrorMessage.INVALID_BONUS_NUMBER;

public class BonusNumber {

    private final LottoNumber value;

    private BonusNumber(LottoNumber value) {
        this.value = value;
    }

    public static BonusNumber of(LottoNumber value, Lotto numbers) {
        validate(value, numbers);
        return new BonusNumber(value);
    }

    public static BonusNumber of(String value, Lotto numbers) {
        try{
            return of(LottoNumber.valueOf(value), numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static void validate(LottoNumber value, Lotto numbers) {
        isNotDuplicated(value, numbers);
    }

    private static void isNotDuplicated(LottoNumber value, Lotto numbers) {
        if(numbers.contains(value)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public LottoNumber getValue() {
        return value;
    }
}
