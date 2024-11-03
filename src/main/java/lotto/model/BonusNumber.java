package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class BonusNumber {
    private final LottoNumber number;

    public BonusNumber(final String number) {
        this.number = new LottoNumber(number);
    }

    public boolean match(int number) {
        return this.number.equals(new LottoNumber(String.valueOf(number)));
    }
}
