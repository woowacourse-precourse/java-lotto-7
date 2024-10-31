package lotto.view.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("숫자 형식의 문자열을 숫자로 파싱할 수 있다.")
    @Test
    void parseToInteger() {
        //given
        String input = "12345678";
        //when
        Integer integer = numberParser.parseToInt(input);
        //then
        assertThat(integer).isEqualTo(12345678);
    }

    @DisplayName("문자열이 숫자 형식이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ㅇ", "1ooo", "I000"})
    void throwExceptionWhenInputIsNotNumberFormat(String input) {
        assertThatThrownBy(() -> numberParser.parseToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 숫자입니다.");
    }
}