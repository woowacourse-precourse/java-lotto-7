package lotto.util;

import static lotto.constant.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_LENGTH;
import static lotto.constant.ErrorMessage.INVALID_NUMBER_PARSE;
import static lotto.constant.ErrorMessage.INVALID_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    @Test
    void 로또_번호의_개수가_유효하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateNumberCount(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_LENGTH.getMessage());
    }

    @Test
    void 로또_번호가_유효한_범위를_벗어나면_예외가_발생한다1() {
        assertThatThrownBy(() -> LottoValidator.validateNumberRange(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 로또_번호가_유효한_범위를_벗어나면_예외가_발생한다2() {
        assertThatThrownBy(() -> LottoValidator.validateNumberRange(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.validateNoDuplicates(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 문자열을_숫자로_변환할_때_유효하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoValidator.parseNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_PARSE.getMessage());
    }
}