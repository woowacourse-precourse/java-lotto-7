package lotto;

import lotto.dto.response.TicketResponse;
import lotto.service.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTicketsTest {
    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(8000, new int[]{0, 0, 0, 0, 0, 1, 0}, 62.5), // 5등 1회 당첨
                Arguments.of(5000, new int[]{0, 0, 1, 0, 0, 1, 0}, 600100.0) // 2등 1회, 5등 1회 당첨
        );
    }
    @DisplayName("가격을 입력 했을시 적절한 티켓 개수가 반환된다.")
    @Test
    void 가격을_입력_했을시_적절한_티켓_개수가_반환된다() {
        LottoTickets lottoTickets = new LottoTickets();
        int money = 8000;

        TicketResponse ticketResponse = lottoTickets.buyTicket(money);

        assertThat(ticketResponse.tickets().size()).isEqualTo(8);
    }

    @DisplayName("로또 티켓의 순위를 계산한다")
    @Test
    void 로또_티켓의_순위를_계산한다() {
        LottoTickets lottoTickets = new LottoTickets();
        List<List<Integer>> tickets = List.of(
                List.of(1, 2, 3, 4, 5, 6),   // 1등
                List.of(1, 2, 3, 4, 5, 7),   // 2등
                List.of(1, 2, 3, 4, 5, 11),  // 3등
                List.of(1, 2, 3, 4, 11, 12), // 4등
                List.of(1, 2, 3, 11, 12, 13) // 5등
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        int[] result = lottoTickets.draw(tickets, winningNumbers, bonusNumber);

        assertEquals(1, result[1]);
        assertEquals(1, result[2]);
        assertEquals(1, result[3]);
        assertEquals(1, result[4]);
        assertEquals(1, result[5]);
    }

    @DisplayName("수익률을 계산한다")
    @ParameterizedTest(name = "입력 금액: {0}, 결과: {1}, 예상 수익률: {2}")
    @MethodSource("provideLottoNumbers")
    void 수익률을_계산한다(int money, int[] result, double expectedProfitRate) {
        LottoTickets lottoTickets = new LottoTickets();

        double profitRate = lottoTickets.calculateProfitRate(money, result);

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

}
