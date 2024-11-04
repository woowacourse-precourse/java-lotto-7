package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("당첨 번호가 1 이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1이상_45이하가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(List.of(46,47,48,49,50,51)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }
}