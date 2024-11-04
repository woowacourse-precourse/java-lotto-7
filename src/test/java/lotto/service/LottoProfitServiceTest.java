package lotto.service;

import lotto.domain.LottoMatch;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProfitServiceTest {

    LottoProfitService lottoProfitService;

    @BeforeEach
    void setUp() {
        lottoProfitService = new LottoProfitService();
    }

    @ParameterizedTest
    @MethodSource("당첨_로또")
    void 당첨_로또_상금_가져오기(List<LottoRank> ranks) {
        //given
        LottoMatch lottoMatch = new LottoMatch(ranks);

        //when
        double totalPrizeMoney = lottoProfitService.getTotalPrizeMoney(lottoMatch);

        //then
        assertThat(totalPrizeMoney).isEqualTo(getExpectedTotalPrizeMoney(ranks));
    }

    @ParameterizedTest
    @MethodSource("당첨_로또_수익률")
    void 당첨_로또_수익률_가져오기(List<LottoRank> ranks, long money, double expectedProfitRate) {
        //given
        LottoMatch lottoMatch = new LottoMatch(ranks);
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(money);

        //when
        double profitPercent = lottoProfitService.calculateProfitPercent(lottoMatch, lottoPurchaseMoney);

        //then
        assertThat(profitPercent).isEqualTo(expectedProfitRate);
    }

    private double getExpectedTotalPrizeMoney(List<LottoRank> ranks) {
        return ranks.stream().mapToDouble(LottoRank::getPrizeMoney).sum();
    }

    static Stream<Arguments> 당첨_로또() {
        return Stream.of(
                Arguments.of(List.of(LottoRank.FIFTH, LottoRank.SECOND)),
                Arguments.of(List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD)),
                Arguments.of(List.of(LottoRank.NO_RANK, LottoRank.NO_RANK, LottoRank.NO_RANK, LottoRank.NO_RANK))
        );
    }

    static Stream<Arguments> 당첨_로또_수익률() {
        return Stream.of(
                Arguments.of(
                        List.of(LottoRank.FIFTH, LottoRank.SECOND),
                        2000L,
                        1500250d
                ),
                Arguments.of(
                        List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD),
                        3000L,
                        67716666.7d
                ),
                Arguments.of(
                        List.of(LottoRank.NO_RANK, LottoRank.NO_RANK, LottoRank.NO_RANK, LottoRank.NO_RANK),
                        4000L,
                        0d
                ),
                Arguments.of(
                        List.of(LottoRank.FIFTH),
                        8000L,
                        62.5d
                )
        );
    }
}