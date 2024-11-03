package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"12312", "0", "000", "003", "-1302113213132"})
    void parseLong_기능_테스트(String input) {
        assertThat(InputParser.parseLong(input)).isInstanceOf(Long.class);
    }

    @Test
    void parseListOfInteger_기능_테스트() {
        assertThat(InputParser.parseListOfInteger("1,2,3,4,5")).isEqualTo(List.of(1, 2, 3, 4, 5));
        assertThat(InputParser.parseListOfInteger("0")).isEqualTo(List.of(0));
        assertThat(InputParser.parseListOfInteger("000,11,44,-999999")).isEqualTo(List.of(0, 11, 44, -999999));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12312", "0", "000", "003", "-13021"})
    void parseInt_기능_테스트(String input) {
        assertThat(InputParser.parseInt(input)).isInstanceOf(Integer.class);
    }
}
