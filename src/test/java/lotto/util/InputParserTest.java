package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"12312", "0", "000", "003", "-13021"})
    void 변환_가능한_String을_넣으면_long을_반환(String input) {
        assertThat(InputParser.parseLong(input)).isInstanceOf(Long.class);
    }
}
