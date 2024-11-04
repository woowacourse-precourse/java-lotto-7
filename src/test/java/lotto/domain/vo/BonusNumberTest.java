package lotto.domain.vo;

import static lotto.common.constant.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    @DisplayName("BonusNumber 선언은 로또 범위 검증을 포함한다")
    void BonusNumberShouldBeValidOnRange() {
        String numberByString = "50";
        int number = 50;

        assertThatThrownBy(() -> new BonusNumber(numberByString))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_IN_RANGE.toString());
        assertThatThrownBy(() -> new BonusNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(MUST_BE_IN_RANGE.toString());
    }
}