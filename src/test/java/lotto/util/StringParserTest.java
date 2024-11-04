package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.handler.ParseErrorHandler;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @Test
    void 문자에서_숫자로_변환_테스트() {
        //given
        String input = "1";

        //when
        Integer number = StringParser.toNumber(input);

        //then
        assertThat(1)
                .isEqualTo(number);
    }

    @Test
    void 문자에서_숫자로_변환_예외_테스트() {
        //given
        String input = "a";

        //when,then
        assertThatThrownBy(
                () -> StringParser.toNumber(input)
        ).isInstanceOf(ParseErrorHandler.class);
    }

    @Test
    void 문자열에서_숫자_리스트로_변환_테스트() {
        //given
        String input = "1,2,3";

        //when
        List<Integer> numbers = StringParser.toNumbers(input);

        //then
        assertThat(List.of(1, 2, 3))
                .isEqualTo(numbers);
    }

    @Test
    void 문자열에서_숫자_리스트로_변환_예외_테스트() {
        //given
        String input = "a,b,c,1,2,3";

        //when,then
        assertThatThrownBy(
                () -> StringParser.toNumbers(input)
        ).isInstanceOf(ParseErrorHandler.class);
    }
}
