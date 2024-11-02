package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_번호는_1에서_45_사이_입니다(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
    }
}