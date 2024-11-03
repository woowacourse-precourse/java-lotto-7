package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또는 개당 1000원으로 올바른 개수가 발행되어야 한다.")
    @Test
    void 로또의_발행_개수_검증() {
        int purchaseAmount = 5000;

        List<Lotto> tickets = Lotto.generateLottoTickets(purchaseAmount);

        assertThat(tickets).hasSize(5);
    }

    @DisplayName("로또 번호의 개수는 6개이어야 한다.")
    @Test
    void 로또_번호의_개수_검증() {
        int purchaseAmount = 5000;

        List<Lotto> tickets = Lotto.generateLottoTickets(purchaseAmount);

        tickets.forEach(ticket -> {
            assertThat(ticket.getNumbers()).hasSize(6);
        });
    }

    @DisplayName("각 로또 번호는 1과 45사이의 범위를 가져야 한다.")
    @Test
    void 로또_번호의_범위_검증() {
        int purchaseAmount = 5000;

        List<Lotto> tickets = Lotto.generateLottoTickets(purchaseAmount);

        tickets.forEach(ticket -> {
            assertThat(ticket.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
        });
    }

    @DisplayName("로또 번호는 정렬되어있어야 한다.")
    @Test
    void 로또_번호의_정렬_검증() {
        int purchaseAmount = 5000;

        List<Lotto> tickets = Lotto.generateLottoTickets(purchaseAmount);

        tickets.forEach(ticket -> {
            assertThat(ticket.getNumbers()).isSorted();
        });
    }
}
