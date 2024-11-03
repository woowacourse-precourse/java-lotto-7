package lotto.Validator;

import static lotto.error.ErrorCode.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {

    @DisplayName("정상적인 로또 번호 검증을 성공한다.")
    @Test
    void validateLottoNumber() {
        List<Integer> numbers = List.of(1,2,3,4,5,45);

        assertThatCode(() -> LottoNumberValidator.validateLottoNumber(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 6개가 아닐 경우 예외를 발생시킨다.")
    @Test
    void validateSize() {

        List<Integer> lessNumbers = List.of(1,2,3,4,5);
        List<Integer> moreNumbers = List.of(1,2,3,4,5,6,7);

        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(lessNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(moreNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("중복된 로또 번호가 있을 시 예외를 발생시킨다.")
    @Test
    void validateDuplicate() {

        List<Integer> duplicateNumbers = List.of(1,2,3,4,5,5);

        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(duplicateNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_DUPLICATE.getMessage());
    }

    @DisplayName("로또 번호 범위가 1부터 45 사이가 아닐 시 예외를 발생시킨다.")
    @Test
    void validateRange() {
        List<Integer> outOfRangeNumbers1 = List.of(1,2,3,4,5,46);
        List<Integer> outOfRangeNumbers2 = List.of(0,2,3,4,5,45);

        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(outOfRangeNumbers1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumber(outOfRangeNumbers2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_RANGE.getMessage());

    }
}