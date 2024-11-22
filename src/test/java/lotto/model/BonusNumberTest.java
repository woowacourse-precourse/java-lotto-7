package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("범위 외 번호를 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 99, -99})
    void throwExceptionIfIsOutOfRange(int number) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
