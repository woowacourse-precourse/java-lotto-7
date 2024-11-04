package lotto.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "19999", "20000"})
    @DisplayName("ParseStringToInt 테스트")
    void String이_int로_변환되면_성공한다(String input) {
        //given
        int expected = Integer.parseInt(input);
        //when
        int parsedInput = parser.parseStringToInt(input);
        //then
        Assertions.assertThat(parsedInput).isEqualTo(expected);
    }
    @ParameterizedTest
    @ValueSource(strings = {"1", "19999", "20000"})
    @DisplayName("ParseStringToInt 테스트")
    void String이_long으로_변환되면_성공한다(String input) {
        //given
        long expected = Long.parseLong(input);
        //when
        long parsedInput = parser.parseStringToLong(input);
        //then
        Assertions.assertThat(parsedInput).isEqualTo(expected);
    }

}