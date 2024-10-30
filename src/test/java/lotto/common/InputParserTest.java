package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @Test
    void 입력_받은_문자열을_Integer_타입으로_변환() {
        // given
        String input = "100";

        // when
        Integer number = InputParser.parseInteger(input);

        // then
        assertThat(number).isEqualTo(100);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    void 입력_받은_문자열을_List_Integer_타입으로_변환(final String input) {
        // when
        List<Integer> numbers = InputParser.parseIntegers(input);

        // then
        assertThat(numbers).hasSize(6);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 예외_입력_받은_문자열이_숫자가_아닐_경우() {
        // given
        String input = "1000j";

        // when & then
        assertThatThrownBy(() -> InputParser.parseInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 입력 값입니다.");

    }

    @Test
    void 예외_입력_받은_문자열에_문자가_포함된_경우() {
        // given
        String input = "1,2,3,4,5,a";

        // when & then
        assertThatThrownBy(() -> InputParser.parseIntegers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 입력 값입니다.");

    }
}