package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @DisplayName("문자열이 콤마를 기준으로 파싱된다.")
    @Test
    void parseInput() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<String> parsedInput = InputParser.parseInput(input);

        // then
       assertThat(parsedInput).isEqualTo(List.of("1","2","3","4","5","6"));
    }

}