package lotto.domain;

import lotto.domain.BonusNumber;
import lotto.global.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateBonusNumberRange(int invalidNumber) {
        // when & then
        assertThatThrownBy(() -> BonusNumber.from(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
    }

    @DisplayName("유효한 보너스 번호를 생성한다.")
    @Test
    void createValidBonusNumber() {
        // when
        BonusNumber bonusNumber = BonusNumber.from(7);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
    }
}