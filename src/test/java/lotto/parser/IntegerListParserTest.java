package lotto.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.parser.IntegerListParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerListParserTest {

    private final IntegerListParser integerListParser;

    IntegerListParserTest() {
        this.integerListParser = new IntegerListParser();
    }


    @Test
    @DisplayName("parse는 delimiter로 구분된 숫자 리스트를 반환한다.")
    void parse_ReturnCorrectly() {
        // given
        String value = "1,2,3";
        String delimiter = ",";

        // when
        List<Integer> result = integerListParser.parse(value, delimiter);

        // then
        assertThat(result)
                .contains(1, 2, 3)
                .hasSize(3);
    }

    @Test
    @DisplayName("parse는 int형으로 변환할 수 없는 경우, NumberFormatException을 던진다.")
    void parse_WithNonParsableInt_ThrowNumberFormatException() {
        // given
        String nonParsableValue = "1,a,3";
        String delimiter = ",";

        // when & then
        assertThatThrownBy(
                () -> integerListParser.parse(nonParsableValue, delimiter)
        ).isInstanceOf(NumberFormatException.class);
    }
}
