package lotto;

import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("BonusNumber를_생성하고_번호를_반환받을_수_있다")
    @Test
    public void get() {
        //given
        BonusNumber bonusNumber = BonusNumber.of(25);

        //when
        int result = bonusNumber.get();

        //then
        assertThat(result).isEqualTo(25);
    }

    @DisplayName("BonusNumber는_로또번호의_범위를_벗어나면_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenNumberIsOutOfRange() {
        //given
        //when
        //then
        assertThatThrownBy(() -> BonusNumber.of(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}