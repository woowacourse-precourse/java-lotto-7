package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.model.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @Test
    @DisplayName("로또 번호는 중복되지 않은 1이상 45이하의 정수 6개로 구성되어야 한다.")
    void validateLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertThatNoException().isThrownBy(() -> LottoValidator.validateLotto(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,-2,-3,100,20000,1002", "1,2,3,3,3,4", "1,2,3", "1,2,3,4,5,6,7"})
    @DisplayName("로또 번호는 중복되지 않은 1이상 45이하의 정수 6개가 아나면 예외가 발생한다")
    void invalidatePriceRange(String input) {
        List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::valueOf).toList();
        Assertions.assertThatThrownBy(() -> LottoValidator.validateLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2000123, -120412, 0})
    @DisplayName("로또 번호는 1이상 45이하의 정수가 아나면 예외가 발생한다")
    void validateNumberRange(int number) {
        Assertions.assertThatThrownBy(() -> LottoValidator.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_RANGE_NUMBER.getMessage());
    }
}