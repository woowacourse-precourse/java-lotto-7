package lotto.validator;

import static lotto.exception.Exception.*;
import static lotto.validator.LottoNumbersValidator.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersValidatorTest {

    @DisplayName("로또 숫자 성공 테스트")
    @Test
    void validateLottoNumber_success() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> validate(numbers));
    }

    @DisplayName("로또 숫자가 6개가 아닐 때 예외 테스트")
    @Test
    void validateLottoNumberSize_fail() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> validate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_SIZE_MUST_BE_SIX.getMessage());
    }
}