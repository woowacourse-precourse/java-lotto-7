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

    @DisplayName("수익률 계산이 정확하게 수행되는지 테스트")
    @Test
    void 수익률_계산_테스트() {
        LottoGame game = new LottoGame();

        // 구입 금액: 5,000원
        int purchaseAmount = 5000;

        // 당첨 결과 (예: 1등 1개, 3등 1개)
        Map<PrizeRank, Integer> resultMap = Map.of(
                PrizeRank.FIRST, 1,
                PrizeRank.THIRD, 1
        );

        // 수익률 계산
        double totalPrize = game.calculateTotalPrize(resultMap);
        double yield = (totalPrize / purchaseAmount) * 100;

        // 예상 총 당첨 금액: 2,001,500,000원
        assertThat(totalPrize).isEqualTo(2_001_500_000);
        assertThat(Math.round(yield * 100) / 100.0).isEqualTo(40030000.00);  // 소수점 둘째 자리 반올림
    }
}
