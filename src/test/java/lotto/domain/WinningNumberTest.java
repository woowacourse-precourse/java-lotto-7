package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ExceptionCode.DUPLICATED_NUMBER;
import static lotto.exception.ExceptionCode.INCORRECT_NUMBER_COUNTS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("당첨 번호의 개수가 7개보다 적으면 예외가 발생한다.")
    @Test
    void validCountException() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INCORRECT_NUMBER_COUNTS.message());
    }

    @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void validDuplicationException() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER.message());
    }

    @DisplayName("보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void validBonusDuplicationException() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER.message());
    }
}