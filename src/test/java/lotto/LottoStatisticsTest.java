package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;
    private List<Lotto> issuedLottoTickets;
    private Lotto winningLotto;
    private LottoBonus lottoBonus;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
        issuedLottoTickets = new ArrayList<>();
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBonus = new LottoBonus(7, winningLotto);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 1등 당첨")
    void 당첨_통계를_계산한다_1등() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRateReturn()).isEqualTo(200_000_000.00);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 2등 당첨")
    void 당첨_통계를_계산한다_2등() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getRateReturn()).isEqualTo(3_000_000.00);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 3등 당첨")
    void 당첨_통계를_계산한다_3등() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 17)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(result.getRateReturn()).isEqualTo(150_000.00);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 4등 당첨")
    void 당첨_통계를_계산한다_4등() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 15, 17)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.getRateReturn()).isEqualTo(5_000.00);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 5등 당첨")
    void 당첨_통계를_계산한다_5등() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 14, 15, 17)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(result.getRateReturn()).isEqualTo(500.0);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 당첨되지않음")
    void 당첨_통계를_계산한다_당첨되지않음() {
        issuedLottoTickets.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.NONE)).isNull();
        assertThat(result.getRateReturn()).isEqualTo(0.00);
    }

    @Test
    @DisplayName("당첨 통계 계산 - 여러 등수 복합")
    void 당첨_통계를_계산한다_복합_계산() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        assertThat(result.getRankCountMap().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCountMap().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getRankCountMap().get(LottoRank.THIRD)).isEqualTo(1);

        // 총 수익률 계산: (20억 + 3천만 + 150만) / (3000원) * 100
        double expectedRate = Math.round(((double) (2_000_000_000 + 30_000_000 + 1_500_000) / 3000) * 100 * 100) / 100.0;
        assertThat(result.getRateReturn()).isEqualTo(expectedRate);
    }

    @Test
    @DisplayName("수익률 계산을 테스트한다.")
    void 수익률_계산을_테스트한다() {
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        issuedLottoTickets.add(new Lotto(List.of(1, 2, 3, 14, 15, 16)));
        LottoResult result = lottoStatistics.statistics(issuedLottoTickets, winningLotto, lottoBonus);

        // 5000원 * 2장 = 10000원, 구매금액 2000원
        assertThat(result.getRateReturn()).isEqualTo(500.00);
    }
}