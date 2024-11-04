package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("BonusNumber 모델 테스트")
class BonusNumberTest {
    @DisplayName("보너스 번호가 로또 번호의 숫자 범위를 벗어난다면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersAreOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber(60))
                .isInstanceOf(IllegalArgumentException.class);
    }
}