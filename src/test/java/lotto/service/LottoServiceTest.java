package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.constant.category.Rank;
import lotto.model.RankCounter;
import lotto.model.domain.Lotto;
import lotto.model.domain.WinningLotto;
import lotto.util.random.TestRandomUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private TestRandomUtil testRandomUtil;
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        List<Integer> fixedResults = Arrays.asList(7, 8, 9, 10, 11, 12);
        testRandomUtil = new TestRandomUtil(fixedResults);

        lottoService = new LottoService(testRandomUtil);
    }

    @Test
    @DisplayName("로또 구입 금액으로 로또 티켓 수량을 계산")
    void calculateLottoCount() {
        // given
        Integer lottoPurchaseAmount = 3000;

        // when
        Integer result = lottoService.calculateLottoCount(lottoPurchaseAmount);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 구입 금액으로 로또 티켓 수량을 계산: 최대 로또 구입 금액")
    void calculateLottoCount_largePurchaseAmount() {
        // given
        Integer lottoPurchaseAmount = 2147483000;

        // when
        Integer result = lottoService.calculateLottoCount(lottoPurchaseAmount);

        // then
        assertThat(result).isEqualTo(2147483);
    }

    @Test
    @DisplayName("당첨 티켓 생성 확인")
    void createWinningTicket() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        // when
        WinningLotto winningTicket = lottoService.createWinningTicket(numbers, bonusNumber);

        // then
        assertThat(winningTicket).isNotNull();
        assertThat(winningTicket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("여러 장의 로또 티켓 생성 확인")
    void createLottoTickets() {
        // given
        Integer lottoCount = 10;

        // when
        List<Lotto> lottoTickets = lottoService.createLottoTickets(lottoCount);

        // then
        assertThat(lottoTickets).hasSize(10);
        assertThat(lottoTickets.get(0).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
        assertThat(lottoTickets.get(9).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
    }

    @Test
    @DisplayName("여러 장의 로또 티켓 생성 확인: 오름차순")
    void createLottoTickets_ascendingOrder() {
        // given
        List<Integer> fixedResults = Arrays.asList(12, 11, 10, 9, 8, 7);
        testRandomUtil = new TestRandomUtil(fixedResults);
        lottoService = new LottoService(testRandomUtil);
        Integer lottoCount = 10;

        // when
        List<Lotto> lottoTickets = lottoService.createLottoTickets(lottoCount);

        // then
        assertThat(lottoTickets).hasSize(10);
        assertThat(lottoTickets.get(0).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
        assertThat(lottoTickets.get(9).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
    }

    @Test
    @DisplayName("당첨 결과가 RankCounter에 정확히 반영되는지 확인")
    void determineWinning() {
        // given
        WinningLotto winningTicket = lottoService.createWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottoTickets = Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                Lotto.of(Arrays.asList(1, 2, 3, 4, 8, 9)), // 4등
                Lotto.of(Arrays.asList(1, 2, 3, 8, 9, 10)) // 5등
        );

        // when
        RankCounter rankCounter = lottoService.determineWinning(winningTicket, lottoTickets);
        ;

        // then
        assertThat(rankCounter.getRankCount(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankCounter.getRankCount(Rank.SECOND_PLACE)).isEqualTo(1);
        assertThat(rankCounter.getRankCount(Rank.THIRD_PLACE)).isEqualTo(1);
        assertThat(rankCounter.getRankCount(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(rankCounter.getRankCount(Rank.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산 확인")
    void calculateEarningRate() {
        // given
        WinningLotto winningTicket = lottoService.createWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottoTickets = Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등
                Lotto.of(Arrays.asList(1, 2, 3, 4, 8, 9)), // 4등
                Lotto.of(Arrays.asList(1, 2, 3, 8, 9, 10)) // 5등
        );
        RankCounter rankCounter = lottoService.determineWinning(winningTicket, lottoTickets);
        int lottoPurchaseAmount = lottoTickets.size() * 1000;

        // when
        double earningRate = lottoService.calculateEarningRate(rankCounter, lottoPurchaseAmount);

        // then
        assertThat(earningRate).isEqualTo(51833.3);
    }

    @Test
    @DisplayName("수익률 계산 확인: 당첨 없음 시 0.0")
    void calculateEarningRate_noWinning() {
        // given
        WinningLotto winningTicket = lottoService.createWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottoTickets = Arrays.asList(
                Lotto.of(Arrays.asList(8, 9, 10, 11, 12, 13)),
                Lotto.of(Arrays.asList(14, 15, 16, 17, 18, 19))
        );
        RankCounter rankCounter = lottoService.determineWinning(winningTicket, lottoTickets);

        // when
        double earningRate = lottoService.calculateEarningRate(rankCounter, lottoTickets.size());

        // then
        assertThat(earningRate).isEqualTo(0.0);
    }
}
