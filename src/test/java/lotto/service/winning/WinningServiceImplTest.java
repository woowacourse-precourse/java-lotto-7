package lotto.service.winning;

import static lotto.domain.Rank.DRAW;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Rank;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.Winning;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningServiceImplTest {

    private final WinningService winningService = new WinningServiceImpl();
    private Winning winning;

    @BeforeEach
    void initializeWinning() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 9, 18, 27, 36, 45));
        BonusNumber bonusNumber = new BonusNumber(7);
        this.winning = new Winning(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 통계 테스트케이스 A")
    @ParameterizedTest
    @MethodSource("provideLottosCaseA")
    void 당첨_통계_테스트케이스_A(List<Lotto> lottos) throws Exception {
        LottoPurchase purchase = LottoPurchase.purchase(lottos);

        LottoStatistics statistics = winningService.estimate(purchase, winning);
        List<Rank> ranks = statistics.getRanks();
        double profitRate = statistics.getProfitRate();

        assertThat(profitRate).isEqualTo(33_859_250.0);
        assertThat(ranks).containsSequence(FIRST, SECOND, THIRD, FOURTH, FIFTH, DRAW);
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

    @DisplayName("당첨 통계 테스트케이스 B")
    @ParameterizedTest
    @MethodSource("provideLottosCaseB")
    void 당첨_통계_테스트케이스_B(List<Lotto> lottos) throws Exception {
        LottoPurchase purchase = LottoPurchase.purchase(lottos);

        LottoStatistics statistics = winningService.estimate(purchase, winning);
        List<Rank> ranks = statistics.getRanks();
        double profitRate = statistics.getProfitRate();

        assertThat(profitRate).isEqualTo(62.5);
        assertThat(ranks).doesNotContain(FIRST, SECOND, THIRD, FOURTH);
        assertThat(ranks).containsSequence(FIFTH, DRAW);
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
                new Lotto(List.of(1, 9, 18, 7, 22, 44))) // 5등 5천원
            // -- 기대값 --
            // 순이익 5천원
            // 투자 비용 8천원
            // 수익률 62.5%
        ));
    }
}