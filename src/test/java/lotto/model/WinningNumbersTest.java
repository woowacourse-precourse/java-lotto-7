package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("WinningNumbers 모델 테스트")
class WinningNumbersTest {
    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersCountIsNotLottoCount() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersContainDuplicate() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 로또 번호의 숫자 범위를 벗어난 숫자가 있으면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersAreOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 1, 2, 3, 4, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}