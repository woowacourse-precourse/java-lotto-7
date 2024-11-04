package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoGeneratorTest {

    private final LottoGenerator generator = new LottoGenerator();

    @DisplayName("로또 생성기는 6개의 고유한 번호를 생성한다.")
    @Test
    void generateLotto_WithSixUniqueNumbers_CreatesValidLotto() {
        Lotto lotto = generator.generate();
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
    }

    @DisplayName("로또 생성기는 지정된 개수의 로또 티켓을 생성한다.")
    @Test
    void generateTickets_WithValidTicketCount_CreatesCorrectNumberOfTickets() {
        int ticketCount = 5;
        List<Lotto> tickets = generator.generateTickets(ticketCount);

        assertThat(tickets).hasSize(ticketCount);
        for (Lotto lotto : tickets) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            assertThat(numbers).doesNotHaveDuplicates();
            assertThat(numbers).allMatch(num -> num >= 1 && num <= 45);
        }
    }

    @DisplayName("로또 생성기는 0개의 티켓을 요청하면 빈 리스트를 반환한다.")
    @Test
    void generateTickets_WithZeroTicketCount_ReturnsEmptyList() {
        int ticketCount = 0;
        List<Lotto> tickets = generator.generateTickets(ticketCount);

        assertThat(tickets).isEmpty();
    }
}
