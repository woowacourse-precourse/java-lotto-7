package lotto.model.draw;

import static lotto.constant.ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE;
import static lotto.constant.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    DrawNumbers drawNumbers = new DrawNumbers("1,2,3,4,5,6");

    @Test
    void 보너스번호_입력_테스트() {
        // given
        String bonusNumberInput = "7";
        // when
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInput, drawNumbers);
        // then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "abc"})
    void 보너스번호_양수가아닌입력_예외테스트(String bonusNumberInput) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumberInput, drawNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER_FORMAT.getFormatMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 보너스번호_범위_예외테스트(String bonusNumberInput) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumberInput, drawNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER_FORMAT.getFormatMessage());
    }

    @Test
    void 보너스번호_중복_예외테스트() {
        assertThatThrownBy(() -> new BonusNumber("1", drawNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BONUS_NUMBER_DUPLICATE.getFormatMessage());
    }
}
