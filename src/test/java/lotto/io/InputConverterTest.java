package lotto.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputConverterTest {

    @Test
    void 숫자가_아닌_가격을_입력하면_예외가_발생한다() {
        // given
        InputConverter inputConverter = new InputConverter();

        // when & then
        assertThatThrownBy(() -> inputConverter.convertToLottoAmount("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    void 숫자가_아닌_당첨_번호를_입력하면_예외가_발생한다() {
        // given
        String[] splitNumbers = {"1", "2", "3", "4", "5", "a"};
        InputConverter inputConverter = new InputConverter();

        // when & then
        assertThatThrownBy(() -> inputConverter.convertToWiningNumbers(splitNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    void 숫자가_아닌_보너스_번호를_입력하면_예외가_발생한다() {
        // given
        String number = "a";
        InputConverter inputConverter = new InputConverter();

        // when & then
        assertThatThrownBy(() -> inputConverter.convertToBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }
}
