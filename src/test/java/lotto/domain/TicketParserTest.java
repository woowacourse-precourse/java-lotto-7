package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class TicketParserTest {

    @Test
    void 변환_성공() {
        //given
        String input = "30000";
        int expected = Integer.parseInt(input) / TicketParser.TICKET_PRICE;

        //when
        Integer parsed = TicketParser.parse(input);

        //then
        assertThat(parsed).isEqualTo(expected);
    }
}