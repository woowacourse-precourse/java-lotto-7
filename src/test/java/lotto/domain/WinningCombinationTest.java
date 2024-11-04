package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.winning.Bonus;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningCombination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningCombinationTest {

    @DisplayName("보너스 번호가 당첨 번호에 포함될 수 없다.")
    @Test
    void validateBonusNotInWinningNumbersTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus invalidBonus = new Bonus("3");

        assertThatThrownBy(() -> new WinningCombination(winningLotto, invalidBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
    }


    @DisplayName("로또의 당첨 결과 개수를 확인한다.")
    @ParameterizedTest
    @MethodSource("lottoWinningResultTestData")
    void lottoWinningResultTest(List<Lotto> lottoList, Map<Rank, Integer> expectedResults) {
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        Bonus bonus = new Bonus("7");
        WinningCombination winningCombination = new WinningCombination(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonus
        );

        Map<Rank, Integer> result = winningCombination.lottoWinningResult(lottoTicket);

        assertThat(result).isEqualTo(expectedResults);
    }

    static Stream<Arguments> lottoWinningResultTestData() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                                new Lotto(List.of(1, 2, 3, 11, 12, 13))
                        ),
                        Map.of(
                                Rank.FIRST, 1,
                                Rank.SECOND, 1,
                                Rank.THIRD, 1,
                                Rank.FOURTH, 1,
                                Rank.FIFTH, 1
                        )
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(8, 9, 10, 11, 12, 13))
                        ),
                        Map.of(
                                Rank.FIRST, 2,
                                Rank.THIRD, 1,
                                Rank.NONE, 1
                        )
                )
        );
    }

    @DisplayName("로또의 수익률을 계산한다.")
    @Test
    void calculateProfitRateTest() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10))
        ));

        Bonus bonus = new Bonus("7");
        WinningCombination winningCombination = new WinningCombination(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonus
        );

        Map<Rank, Integer> rankCounts = winningCombination.lottoWinningResult(lottoTicket);
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");

        double profitRate = winningCombination.calculateProfitRate(rankCounts, purchaseAmount);
        double expectedProfitRate = ((2000000000 + 30000000 + 50000) / 3000.0) * 100;

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
