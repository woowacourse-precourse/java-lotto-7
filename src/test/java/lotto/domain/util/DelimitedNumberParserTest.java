package lotto.domain.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import java.util.List;
import lotto.domain.util.parser.DelimitedNumberParser;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class DelimitedNumberParserTest {

    @Nested
    class 당첨번호_파싱_성공 {

        @Test
        void 공백_미포함() {
            //given
            String input = "1,2,3,4,5,6";
            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
            DelimitedNumberParser parser = DelimitedNumberParser.getInstance();

            //when
            List<Integer> parse = parser.parse(input);

            //then
            assertThat(parse).isEqualTo(expected);
        }

        @Test
        void 공백_포함() {
            //given
            String input = "1, 2, 3, 4, 5, 6";
            List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
            DelimitedNumberParser parser = DelimitedNumberParser.getInstance();

            //when
            List<Integer> parse = parser.parse(input);

            //then
            assertThat(parse).isEqualTo(expected);
        }
    }
}