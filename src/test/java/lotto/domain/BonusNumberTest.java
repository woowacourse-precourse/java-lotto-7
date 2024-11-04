package lotto.domain;

import lotto.domain.validator.DefaultRangeValidator;
import lotto.domain.validator.RangeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    private final RangeValidator rangeValidator = new DefaultRangeValidator();

    @DisplayName("보너스 번호가 null이면 예외를 던진다.")
    @Test
    void bonusNumberCannotBeNull() {
        assertThatThrownBy(() -> new BonusNumber(null, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 null 일 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1과 45 사이 범위를 넘어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void bonusNumberShouldBeBetween1And45(Integer bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, rangeValidator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1 ~ 45 사이의 숫자입니다.");
    }

}
