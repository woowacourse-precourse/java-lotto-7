package lotto.domain.winning;

import static lotto.domain.winning.Rank.FIFTH;
import static lotto.domain.winning.Rank.FIRST;
import static lotto.domain.winning.Rank.FOURTH;
import static lotto.domain.winning.Rank.NOTHING;
import static lotto.domain.winning.Rank.SECOND;
import static lotto.domain.winning.Rank.THIRD;
import static lotto.resources.Constants.THOUSAND_UNIT;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.buyer.Buyer;
import lotto.domain.buyer.BuyerFactory;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosFactory;
import lotto.domain.number.Number;
import lotto.domain.number.NumberFactory;
import lotto.domain.number.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {
    LottoMatcher lottoMatcher;
    Buyer buyer;
    WinningInfo winningInfo;
    WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();

        // 1 ~ 5등 1개씩, 꽝 3개
        Lotto firstCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto thirdCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 16));
        Lotto fourthCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 15, 16));
        Lotto fifthCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 14, 15, 16));
        Lotto nothingCustomLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 13, 14, 15, 16));
        Lotto nothingCustomLotto2 = LottoFactory.createCustomLotto(Arrays.asList(1, 12, 13, 14, 15, 16));
        Lotto nothingCustomLotto3 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        Lottos customLottos = LottosFactory.createCustomLottos(Arrays.asList(firstCustomLotto, secondCustomLotto,
                thirdCustomLotto, fourthCustomLotto, fifthCustomLotto, nothingCustomLotto1, nothingCustomLotto2,
                nothingCustomLotto3));

        buyer = BuyerFactory.createTestBuyer(8 * THOUSAND_UNIT, customLottos);

        // 로또 추첨 번호 : 1, 2, 3, 4, 5, 6, 7(보너스번호)
        Numbers winningNumbers = Numbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Number bonusNumber = NumberFactory.from(7);

        winningInfo = WinningInfo.of(winningNumbers, bonusNumber);

        winningStatistics = WinningStatistics.of(lottoMatcher, buyer);
    }

    @DisplayName("당첨 정보와 구매자가 구입한 로또를 바탕으로 몇 개가 당첨되었는지를 계산한다.")
    @Test
    void 당첨_정보와_구매자가_구입한_로또를_바탕으로_몇_개가_당첨되었는지를_계산한다() {
        winningStatistics.calculateWinningStatistics(buyer, winningInfo);

        Map<Rank, Integer> statistics = winningStatistics.getStatistics();

        Assertions.assertThat(statistics.get(FIRST)).isEqualTo(1);
        Assertions.assertThat(statistics.get(SECOND)).isEqualTo(1);
        Assertions.assertThat(statistics.get(THIRD)).isEqualTo(1);
        Assertions.assertThat(statistics.get(FOURTH)).isEqualTo(1);
        Assertions.assertThat(statistics.get(FIFTH)).isEqualTo(1);
        Assertions.assertThat(statistics.get(NOTHING)).isEqualTo(3);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void 총_수익률을_계산한다() {
        winningStatistics.calculateWinningStatistics(buyer, winningInfo);
        Double expectedRate = 25394437.5;

        Assertions.assertThat(winningStatistics.getReturnRate())
                .isEqualTo(expectedRate);
    }

    @DisplayName("총 수익률이 0인 경우를 확인한다.")
    @Test
    void 총_수익률이_0인_경우를_확인한다() {
        Lottos customLottos = LottosFactory.createCustomLottos(Arrays.asList(
                LottoFactory.createCustomLotto(Arrays.asList(10, 11, 12, 13, 14, 15)),
                LottoFactory.createCustomLotto(Arrays.asList(16, 17, 18, 19, 20, 21))
        ));
        buyer = BuyerFactory.createTestBuyer(2 * THOUSAND_UNIT, customLottos);

        WinningStatistics noWinningStatistics = WinningStatistics.of(lottoMatcher, buyer);
        noWinningStatistics.calculateWinningStatistics(buyer, winningInfo);

        Double expectedRate = 0.0;

        Assertions.assertThat(noWinningStatistics.getReturnRate())
                .isEqualTo(expectedRate);
    }


    @DisplayName("문자열로 출력하는 기능을 확인한다.")
    @Test
    void 문자열로_출력하는_기능을_확인한다() {
        winningStatistics.calculateWinningStatistics(buyer, winningInfo);
        String expectedString = getExpectedWinningStatisticsString();

        String resultString = winningStatistics.toString();

        Assertions.assertThat(resultString).isEqualTo(expectedString);
    }

    @DisplayName("부분적인 당첨 결과를 확인한다.")
    @Test
    void 부분적인_당첨_결과를_확인한다() {
        Lotto fourthCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 15, 16));
        Lotto fifthCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 14, 15, 16));
        Lotto nothingCustomLotto = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 13, 14, 15, 16));

        Lottos customLottos = LottosFactory.createCustomLottos(
                Arrays.asList(fourthCustomLotto, fifthCustomLotto, nothingCustomLotto));

        buyer = BuyerFactory.createTestBuyer(3 * THOUSAND_UNIT, customLottos);

        // 로또 추첨 번호 : 1, 2, 3, 4, 5, 6, 7(보너스번호)
        Numbers winningNumbers = Numbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Number bonusNumber = NumberFactory.from(7);

        winningInfo = WinningInfo.of(winningNumbers, bonusNumber);

        WinningStatistics anotherWinningStatistics = WinningStatistics.of(lottoMatcher, buyer);
        anotherWinningStatistics.calculateWinningStatistics(buyer, winningInfo);

        String expectedString = getExpectedPartialWinningStatisticsString();

        String resultString = anotherWinningStatistics.toString();

        Assertions.assertThat(resultString).isEqualTo(expectedString);
    }

    private String getExpectedWinningStatisticsString() {
        return """

                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 1개
                총 수익률은 25394437.5%입니다.""";
    }

    private String getExpectedPartialWinningStatisticsString() {
        return """

                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 1833.3%입니다.""";
    }
}
