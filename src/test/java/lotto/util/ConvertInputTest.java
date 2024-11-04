package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConvertInputTest {
    @Test
    void 구입금액에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> ConvertInput.makeMoneyToInt("우테코프리코스"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({"1000,1000", "3000,3000", "450,450"})
    @ParameterizedTest
    void 구입금액에_수를_입력하면_예외가_발생하지_않는다(String input, int expected) {
        assertThat(ConvertInput.makeMoneyToInt(input)).isEqualTo(expected);
    }
}
