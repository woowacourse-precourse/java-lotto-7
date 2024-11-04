package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("보너스 번호는 지정된 범위 안에서 포함되어야한다.")
    @Test
    void invalidRangeTest() {
        assertThatThrownBy(() -> new BonusNumber(47,new Lotto(List.of(1, 2, 3, 4, 5,45))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUM_RANGE.getMessage());
    }

    @DisplayName("보너스 번호는 중복되면 안된다")
    @Test
    void invalidDuplicateTest() {
        assertThatThrownBy(() -> new BonusNumber(1,new Lotto(List.of(1, 2, 3, 4, 5,45))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUM_DUPLICATE.getMessage());
    }
}