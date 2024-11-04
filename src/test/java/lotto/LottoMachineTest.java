package lotto;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("로또 티켓 발행 및 번호 오름차순 정렬 확인")
    @Test
    void 로또_티켓_발행_및_정렬() {
        LottoMachine machine = new LottoMachine();
        List<Lotto> tickets = machine.createTickets(3000);  // 3개의 로또 티켓

        assertThat(tickets).hasSize(3);
        for (Lotto ticket : tickets) {
            List<Integer> numbers = ticket.getNumbers();
            assertThat(numbers).isSorted();  // 번호가 오름차순으로 정렬되어 있는지 확인
        }
    }
}

class LottoGameTest {

    @DisplayName("당첨 내역 계산 및 출력 확인")
    @Test
    void 당첨_내역_계산_및_출력() {
        LottoGame game = new LottoGame();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 로또 티켓 목록 (이 예제에서는 수동 생성으로 테스트)
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4등
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 5등
        );

        Map<PrizeRank, Integer> results = game.calculateResults(tickets, winningNumbers, bonusNumber);

        assertThat(results.get(PrizeRank.FIRST)).isEqualTo(1);
        assertThat(results.get(PrizeRank.SECOND)).isEqualTo(1);
        assertThat(results.get(PrizeRank.THIRD)).isEqualTo(1);
        assertThat(results.get(PrizeRank.FOURTH)).isEqualTo(1);
        assertThat(results.get(PrizeRank.FIFTH)).isEqualTo(1);
    }
}
