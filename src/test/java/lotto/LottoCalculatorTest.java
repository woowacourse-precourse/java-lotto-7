package lotto;

import static lotto.LottoCalculator.calculateProfitRate;
import static lotto.LottoCalculator.calculateRank;
import static lotto.LottoCalculator.countMatches;
import static lotto.LottoCalculator.countMatchesWithBonus;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCalculatorTest {

    @Test
    void countMatchesTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 14, 22, 45));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int expected = 3;

        //when
        int actual = countMatches(lotto, winningNumbers);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("보너스 볼 일치 및 불일치 경우")
    @CsvSource({
            "7, true",
            "1, false"
    })
    void countMatchesWithBonusTest(int bonusNumber, boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(7, 11, 30, 40, 42, 43));

        // when
        boolean matchBonus = countMatchesWithBonus(lotto, bonusNumber);

        // then
        assertThat(matchBonus).isEqualTo(expected);
    }

    @Test
    @DisplayName("5개 일치, 보너스 볼 일치 (30,000,000원)")
    void calculateSecondRankTest() {
        //given
        Lotto lotto = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        List<Integer> winningNumbers = List.of(11, 30, 40, 42, 37, 43);
        int bonusNumber = 7;

        //when
        Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);

        //then
        assertAll(
                () -> assertThat(rank.getResult()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)"),
                () -> assertThat(rank.getMatchCount()).isEqualTo(5),
                () -> assertThat(rank.isMatchBonus()).isEqualTo(true),
                () -> assertThat(rank.getReward()).isEqualTo(30_000_000)
        );
    }

    @Test
    @DisplayName("6개 일치 (2,000,000,000원)")
    void calculateFirstRankTest() {
        //given
        Lotto lotto = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        List<Integer> winningNumbers = List.of(7, 11, 30, 40, 42, 43);
        int bonusNumber = 8;

        //when
        Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);

        //then
        assertAll(
                () -> assertThat(rank.getResult()).isEqualTo("6개 일치 (2,000,000,000원)"),
                () -> assertThat(rank.getMatchCount()).isEqualTo(6),
                () -> assertThat(rank.isMatchBonus()).isEqualTo(false),
                () -> assertThat(rank.getReward()).isEqualTo(2_000_000_000)
        );
    }

    @Test
    void calculateTotalRank() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45)),
                new Lotto(List.of(4, 18, 21, 33, 37, 39))
        );
        List<Integer> winningNumbers = List.of(8, 11, 30, 40, 42, 43);
        int bonusNumber = 7;

        //when
        Map<Rank, Integer> rankCount = LottoCalculator.calculateTotalRank(lottos,winningNumbers,bonusNumber);

        //then
        assertAll(
                () -> assertThat(rankCount.get(Rank.SECOND)).isEqualTo(1)
        );
    }

    @Test
    void calculateTotalReward() {
        //given
        Map<Rank, Integer> rankCount = new HashMap<>();
        rankCount.put(Rank.FIRST, 3);
        rankCount.put(Rank.SECOND, 2);
        rankCount.put(Rank.NONE, 5);

        //when
        long totalReward = LottoCalculator.calculateTotalReward(rankCount);

        //then
        assertThat(totalReward).isEqualTo(6_060_000_000L);
    }

    @Test
    void calculateProfitRateTest() {
        //given
        long totalReward = 10_000L;
        int purchaseAmount =8000;

        //when
        double profitRate = calculateProfitRate(totalReward,purchaseAmount);

        //then
        assertThat(profitRate).isEqualTo(125);
    }
}
