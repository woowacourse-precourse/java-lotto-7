package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

class UniqueLottoNumbersValidatorTest {
    @Test
    void 로또_번호가_중복되지_않으면_예외가_발생하지_않는다() {
        List<Integer> uniqueLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        UniqueLottoNumbersValidator validator = new UniqueLottoNumbersValidator(uniqueLottoNumbers);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 로또_번호가_중복되면_예외가_발생한다() {
        List<Integer> duplicateLottoNumbers = List.of(1, 2, 3, 4, 5, 5); // 5가 중복됨
        UniqueLottoNumbersValidator validator = new UniqueLottoNumbersValidator(duplicateLottoNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBERS);
    }
}