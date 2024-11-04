package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45 범위 밖에 있으면 예외를 발생시킨다.")
    @Test
    void outNumberRange() {
        assertThatThrownBy(() -> BonusNumber.from(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
