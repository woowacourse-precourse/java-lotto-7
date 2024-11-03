package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TicketCountTest {

    @DisplayName("로또 티켓 개수는 구입 금액을 1000으로 나눈 값이다.")
    @ParameterizedTest
    @MethodSource("provideAmountForTicketCount")
    public void IsValidIfAmountMultipleOfThousand(String inputAmount, TicketCount ticketExpected) {
        // given
        InputAmount amount = new InputAmount(inputAmount);

        // when
        TicketCount ticketCount = new TicketCount(amount);

        // then
        assertThat(ticketCount).isEqualTo(ticketExpected);
    }

    private static Stream<Arguments> provideAmountForTicketCount () {
        return Stream.of(
                Arguments.of("1000", new TicketCount(new InputAmount("1000"))),
                Arguments.of("2000", new TicketCount(new InputAmount("2000"))),
                Arguments.of("3000", new TicketCount(new InputAmount("3000")))
        );
    }

}
