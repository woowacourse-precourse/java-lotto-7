package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("입력 문자열 정수로 변환 - 성공 테스트")
    void parseInputToInt_success() {
        // given
        String input = "1";

        // when
        Integer parsedInput = Parser.parseInputToInt(input);

        // then
        assertThat(parsedInput).isEqualTo(1);
    }
}