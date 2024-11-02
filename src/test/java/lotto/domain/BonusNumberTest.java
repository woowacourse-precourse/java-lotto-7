package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, -59, 46})
    void 입력한_보너스_번호가_1에서_45사이의_숫자가_아닌_경우_예외가_발생한다(int number) {
        assertThatThrownBy(() -> new BonusNumber(number)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessages.NUMBER_OUT_OF_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 43, 21})
    void 입력한_보너스_번호가_1에서_45사이의_숫자인_경우_예외가_발생하지_않는다(int number) {
        assertThatCode(() -> new BonusNumber(number)).doesNotThrowAnyException();
    }
}
