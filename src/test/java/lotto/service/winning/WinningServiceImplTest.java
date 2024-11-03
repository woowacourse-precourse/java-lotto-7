package lotto.service.winning;

import static lotto.domain.Rank.DRAW;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Rank;
import lotto.domain.Winning;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningServiceImplTest {

    @ParameterizedTest
    @MethodSource("provideLottosCaseA")
    void 당첨_결과_테스트케이스_A(List<Lotto> lottos) throws Exception {
        WinningServiceImpl winningService = new WinningServiceImpl();
        Winning winning = new Winning(List.of(1, 9, 18, 27, 36, 45), 7);
        LottoPurchase purchase = LottoPurchase.purchase(lottos);

        LottoStatistics statistics = winningService.getStatistics(purchase, winning);
        Map<Rank, Integer> rankCounts = statistics.getRankCounts();

        assertThat(statistics.getProfitRate()).isEqualTo(33_859_250.0);
        assertThat(rankCounts.get(FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(FOURTH)).isEqualTo(1);
        assertThat(rankCounts.get(FIFTH)).isEqualTo(1);
        assertThat(rankCounts.get(DRAW)).isEqualTo(1);
    }

    private static Stream<Arguments> provideLottosCaseA() {
        return Stream.of(Arguments.of(
            List.of(new Lotto(List.of(1, 9, 18, 27, 36, 45)), // 1등 20억원
                new Lotto(List.of(7, 9, 18, 27, 36, 45)), // 2등 3천만원
                new Lotto(List.of(2, 9, 18, 27, 36, 45)), // 3등 150만원
                new Lotto(List.of(2, 3, 18, 27, 36, 45)), // 4등 5만원
                new Lotto(List.of(2, 3, 4, 27, 36, 45)),  // 5등 5천원
                new Lotto(List.of(2, 3, 4, 5, 36, 45)))    // 꽝  0원
            // -- 기대값 --
            // 순이익 2_031_555_000원
            // 투자 비용 6천원
            // 수익률 33_859_250%
        ));
    }

    @ParameterizedTest
    @MethodSource("provideLottosCaseB")
    void 당첨_결과_테스트케이스_B(List<Lotto> lottos) throws Exception {
        WinningServiceImpl winningService = new WinningServiceImpl();
        Winning winning = new Winning(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPurchase purchase = LottoPurchase.purchase(lottos);

        LottoStatistics statistics = winningService.getStatistics(purchase, winning);
        Map<Rank, Integer> rankCounts = statistics.getRankCounts();

        assertThat(statistics.getProfitRate()).isEqualTo(62.5);
        assertThat(rankCounts.get(FIRST)).isEqualTo(0);
        assertThat(rankCounts.get(SECOND)).isEqualTo(0);
        assertThat(rankCounts.get(THIRD)).isEqualTo(0);
        assertThat(rankCounts.get(FOURTH)).isEqualTo(0);
        assertThat(rankCounts.get(FIFTH)).isEqualTo(1);
        assertThat(rankCounts.get(DRAW)).isEqualTo(7);
    }

    private static Stream<Arguments> provideLottosCaseB() {
        return Stream.of(Arguments.of(
            List.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)), // 꽝 0원
                new Lotto(List.of(3, 5, 11, 16, 32, 38)), // 꽝 0원
                new Lotto(List.of(7, 11, 16, 35, 36, 44)), // 꽝 0원
                new Lotto(List.of(1, 8, 11, 31, 41, 42)), // 꽝 0원
                new Lotto(List.of(13, 14, 16, 38, 42, 45)), // 꽝 0원
                new Lotto(List.of(7, 11, 30, 40, 42, 43)), // 꽝 0원
                new Lotto(List.of(2, 13, 22, 32, 38, 45)), // 꽝 0원
                new Lotto(List.of(1, 3, 5, 14, 22, 45))) // 5등 5천원
            // -- 기대값 --
            // 순이익 5천원
            // 투자 비용 8천원
            // 수익률 62.5%
        ));
    }
}