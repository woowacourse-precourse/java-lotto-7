package lotto.view.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {

    private NumberParser numberParser;

    @BeforeEach
    void setUp() {
        numberParser = new NumberParser();
    }

    @Test
    void 숫자_형식의_문자열을_숫자로_파싱할_수_있다() {
        //given
        String input = "12345678";
        //when
        Integer integer = numberParser.parseToInt(input);
        //then
        assertThat(integer).isEqualTo(12345678);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅇ", "1ooo", "I000"})
    void 문자열이_숫자_형식이_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> numberParser.parseToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 숫자입니다.");
    }
}