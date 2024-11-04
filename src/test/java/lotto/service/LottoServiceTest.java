package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Amount;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.RankCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또를 발행한다.")
    void issueLotto() {
        //given
        Amount amount = Amount.of("10000");

        //when
        Lottos lottos = lottoService.issueLottos(amount);

        //then
        assertThat(lottos.getLottos()).hasSize(10);
        lottos.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).isSorted()
        );
    }

    @ParameterizedTest(name = "{0} - {1}개")
    @MethodSource("provideWinningCount")
    @DisplayName("당첨 통계를 구한다.")
    void getWinningCount(Rank rank, int expectedCount) {
        //given
        Lottos userLottos = new Lottos(List.of(
                Lotto.of("1, 2, 3, 4, 5, 6"), // 4개 일치
                Lotto.of("1, 3, 5, 7, 9, 11"), // 2개 일치
                Lotto.of("2, 4, 6, 8, 10, 12") // 4개 일치
        ));

        Lotto winningLotto = Lotto.of("1, 2, 4, 6, 7, 8");
        Bonus bonus = Bonus.of("10", winningLotto);

        //when
        RankCount rankCount = lottoService.getRankCount(userLottos, winningLotto, bonus);

        //then
        assertThat(rankCount.getRankCount().get(rank)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> provideWinningCount() {
        return Stream.of(
                Arguments.of(Rank.MATCHES_3, 0),
                Arguments.of(Rank.MATCHES_4, 2),
                Arguments.of(Rank.MATCHES_5, 0),
                Arguments.of(Rank.MATCHES_5_BONUS_MATCH, 0),
                Arguments.of(Rank.MATCHES_6, 0)
        );
    }
}