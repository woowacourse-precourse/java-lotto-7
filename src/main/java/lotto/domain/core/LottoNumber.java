package lotto.domain.core;

import java.util.Objects;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Max;
import lotto.config.validation.annotation.Min;

public class LottoNumber extends FieldValidation {

    @Min(1)
    @Max(45)
    protected final int number;

    public LottoNumber(int number) {
        this.number = number;

        super.valid();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof LottoNumber && ((LottoNumber) obj).number == number;
    }
}
