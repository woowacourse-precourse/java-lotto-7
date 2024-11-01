package lotto.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("LottoTicketService 기능 테스트")
class LottoTicketServiceTest {
    private final LottoTicketService lottoTicketService = new LottoTicketService();

    @DisplayName("로또 구입금액에 0이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsZero() {
        // given
        String input = "0";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> lottoTicketService.getLottoPurchasePrice(input));
    }

    @DisplayName("로또 구입금액이 로또 가격으로 나누어 떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenNotDivisibleByLottoPrice() {
        // given
        String input = "2500";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> lottoTicketService.getLottoPurchasePrice(input));
    }

    @DisplayName("로또 구입금액에 음수가 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNegative() {
        // given
        String input = "-1000";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> lottoTicketService.getLottoPurchasePrice(input));
    }

}