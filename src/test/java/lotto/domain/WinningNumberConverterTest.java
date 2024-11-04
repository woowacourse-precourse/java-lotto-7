package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.WinningNumberConverter;
import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberConverterTest {

    @Test
    void 문자열을_쉼표로_구분해_정수_리스트로_변환() {
        String input = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> actual = WinningNumberConverter.convert(input);

        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", " 1,2, 3, 4 ,5 , 6  "})
    void 공백이_포함되어도_정수_리스트로_변환(String input) {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> actual = WinningNumberConverter.convert(input);

        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,a,3,4,5,6", "1,,3,4,5,6", "1, , 3, 4,5 , 6", "1,_,3,4,5,6"})
    void 정수가_아닌_값이_포함되면_예외_발생(String input) {
        assertThatThrownBy(() -> WinningNumberConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_INTEGER_LOTTO_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1;2;3;4;5;6", "1 2 3 4 5 6", "1/2/3/4/5/6"})
    void 구분자가_쉼표가_아니면_예외_발생(String input) {
        assertThatThrownBy(() -> WinningNumberConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 빈_문자열은_예외_발생(String input) {
        assertThatThrownBy(() -> WinningNumberConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
