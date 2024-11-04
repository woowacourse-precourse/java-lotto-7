package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @Nested
    class 보너스_번호_검증 {

        @Test
        void 보너스_번호가_1에서_45_사이의_양의_정수일_경우_객체가_정상적으로_생성된다() {
            // given
            int validNumber = 30;

            // when
            BonusNumber bonusNumber = BonusNumber.from(validNumber);

            // then
            assertThat(bonusNumber).isInstanceOf(BonusNumber.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {50, 46})
        void 보너스_번호가_1에서_45_사이를_벗어나면_예외가_발생한다(int invalidNumber) {
            // when & then
            assertThatThrownBy(() -> BonusNumber.from(invalidNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {-5, 0})
        void 보너스_번호가_양의_정수가_아니면_예외가_발생한다(int invalidNumber) {
            // when & then
            assertThatThrownBy(() -> BonusNumber.from(invalidNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NEGATIVE_BONUS_NUMBER_NOT_ALLOWED.getMessage());
        }
    }

}