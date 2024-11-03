package lotto.domain.util.parser;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class MoneyParserTest {

    @Test
    void 변환_성공() {
        //given
        String input = "30000";
        int expected = Integer.parseInt(input) / Lotto.TICKET_PRICE;
        MoneyParser parser = MoneyParser.getInstance();

        //when
        Integer parsed = parser.parse(input);

        //then
        assertThat(parsed).isEqualTo(expected);
    }
}