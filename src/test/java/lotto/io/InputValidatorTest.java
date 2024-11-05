package lotto.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = "1000k, !!!, ㄱㄴㄷ")
    void 구입_금액_형변환_테스트(String buyAmount) {
        //given
        InputValidator validator = new InputValidator();

        //when & then
        Assertions.assertThatThrownBy(() -> validator.validateBuyAmount(buyAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_빈칸_테스트() {
        //given
        InputValidator validator = new InputValidator();
        String winningNumbers = "";

        //when & then
        Assertions.assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "3.0, abc, 400@, ㄱㄴㄷ")
    void 보너스_번호_형변환_테스트(String bonusNumber) {
        //given
        InputValidator validator = new InputValidator();

        //when & then
        Assertions.assertThatThrownBy(() -> validator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}