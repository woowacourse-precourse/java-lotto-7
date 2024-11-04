package lotto.domain.util.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.Lotto;
import lotto.domain.exception.MoneyFormatException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class MoneyParserTest {

    @Test
    void 파싱_성공() {
        //given
        String input = "30000";
        int expected = Integer.parseInt(input) / Lotto.TICKET_PRICE;
        MoneyParser parser = MoneyParser.getInstance();

        //when
        Integer parsed = parser.parse(input);

        //then
        assertThat(parsed).isEqualTo(expected);
    }

    @Nested
    class 파싱_실패 {

        @Test
        void 숫자로만_이루어지지_않은_경우() {
            //given
            String input = "30000a";
            MoneyParser parser = MoneyParser.getInstance();

            //when, then
            assertThrows(MoneyFormatException.class, () -> parser.parse(input));
        }

        @Test
        void 양수가_아닐_경우() {
            //given
            String input = "-30000";
            MoneyParser parser = MoneyParser.getInstance();

            //when, then
            assertThrows(MoneyFormatException.class, () -> parser.parse(input));
        }

        @Test
        void 돈이_1000원으로_나누어_떨어지지_않는_경우() {
            //given
            String input = "30012";
            MoneyParser parser = MoneyParser.getInstance();

            //when, then
            assertThrows(MoneyFormatException.class, () -> parser.parse(input));
        }
    }
}