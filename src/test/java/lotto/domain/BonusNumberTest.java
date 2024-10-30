package lotto.domain;

import lotto.error.NumberErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @Test
    void 보너스번호는_문자일_수_없다() {
        //given
        String bonusNumber = "1a";

        //when & then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 보너스번호는_1에서_45_사이여야_한다() {
        //given
        String bonusNumber = "46";

        //when & then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.NOT_ALLOWED_NUMBER.getMessage());
    }

    @Test
    void 정상_테스트() {
        //given
        String bonusNumber = "45";

        //when & then
        assertThatCode(() -> new BonusNumber(bonusNumber))
                .doesNotThrowAnyException();
    }
}