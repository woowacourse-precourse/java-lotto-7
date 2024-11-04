package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.ExceptionMessage.INVALID_LOTTO_NUM_RANGE;
import static lotto.enums.ExceptionMessage.INVALID_MONEY_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    @DisplayName("지정된 범위 밖에 보너스 번호가 들어오면 예외발생")
    @Test
    void invalidBonusNumTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumber(lotto,68))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUM_RANGE.getMessage());
    }

}