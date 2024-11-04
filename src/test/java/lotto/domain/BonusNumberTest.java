package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 10000, -10000})
    @DisplayName("from - 1부터 45사이의 숫자 아니면 예외가 발생한다.")
    void failMakeBonusNumberWhenInvalidRange(int bonus) {
        assertThatThrownBy(() -> BonusNumber.from(bonus))
                .isInstanceOf(LottoException.class)
                .hasMessage(INVALID_BONUS_NUMBER_RANGE.getMessage());
    }
}

