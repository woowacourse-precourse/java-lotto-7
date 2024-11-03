package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.ErrorMessage.OUT_OF_RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void validateNumberCount_Over_Test() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void validateNumberCount_Less_Test() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicateNumber_Test() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다.")
    @Test
    void validateNumberRange_Test() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_NUMBER.getMessage());
    }
}
