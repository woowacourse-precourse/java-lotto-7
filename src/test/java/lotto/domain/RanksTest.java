package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @DisplayName("등수 목록으로 생성할 수 있다.")
    @Test
    void createRanksWithRankList() {
        List<Rank> rankList = List.of(FIRST, SECOND, THIRD, FOURTH);

        Ranks ranks = new Ranks(rankList);

        assertThat(ranks.count()).isEqualTo(4);
    }

    @DisplayName("등수별 금액에 따른 총 금액을 계산하여 반환한다.")
    @ParameterizedTest
    @MethodSource("provideRanksAndPrizeAmount")
    void calculateTotalPrizeAmount(List<Rank> rankList, BigInteger prizeAmount) {
        Ranks ranks = new Ranks(rankList);
        Money prizeMoney = ranks.totalPrizeAmount();

        assertThat(prizeMoney).isEqualTo(new Money(prizeAmount));
    }

    private static Stream<Arguments> provideRanksAndPrizeAmount() {
        return Stream.of(
                Arguments.of(List.of(FIRST), BigInteger.valueOf(2_000_000_000)),
                Arguments.of(List.of(SECOND), BigInteger.valueOf(30_000_000)),
                Arguments.of(List.of(THIRD), BigInteger.valueOf(1_500_000)),
                Arguments.of(List.of(FOURTH), BigInteger.valueOf(50_000)),
                Arguments.of(List.of(FIFTH), BigInteger.valueOf(5_000)),
                Arguments.of(List.of(NONE), BigInteger.ZERO),
                Arguments.of(List.of(THIRD, FOURTH), BigInteger.valueOf(1_550_000)),
                Arguments.of(List.of(SECOND, FIFTH), BigInteger.valueOf(30_005_000))
        );
    }

    @DisplayName("구입 금액에 따른 수익률을 계산하여 반환한다.")
    @Test
    void calculateProfitRate() {
        List<Rank> rankList = List.of(FIFTH);
        Ranks ranks = new Ranks(rankList);
        Money purchaseAmount = new Money(BigInteger.valueOf(13000));

        BigDecimal bigDecimal = ranks.calculateProfitRate(purchaseAmount);

        assertThat(bigDecimal).isEqualTo(new BigDecimal("38.5"));

    }

}
