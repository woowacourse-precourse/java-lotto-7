package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다(final Integer bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호를 알려준다.")
    @Test
    void 보너스_번호_알려준다() {
        BonusNumber bonusNumber = new BonusNumber(45);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(45);
    }

}