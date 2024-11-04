package lotto.domain.lotto.vo;

import static lotto.infrastructure.exception.ErrorCode.INVALID_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Number 클래스 테스트")
class NumberTest {

    @Test
    void 번호가_1_미만_45_초과라면_예외를_발생한다() {
        // given & when & then
        assertThatThrownBy(() -> new Number(47))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}