package lotto.domain.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Length;
import lotto.config.validation.annotation.Unique;
import lotto.domain.core.LottoNumber;

public class WinningNumber extends FieldValidation {

    @Unique
    @Length(min = 6, max = 6)
    private final List<LottoNumber> numbers;

    public WinningNumber(int... numbers) {
        this.numbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        super.valid();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
