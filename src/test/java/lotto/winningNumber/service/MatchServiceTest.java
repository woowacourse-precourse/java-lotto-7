package lotto.winningNumber.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.lottery.domain.Lotto;
import lotto.winningNumber.domain.LottoResult;
import lotto.winningNumber.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatchServiceTest {

    private MatchService matchService = new MatchService();

    @ParameterizedTest
    @DisplayName("로또와 당첨번호를 이용해 당첨결과를 알려준다")
    @MethodSource("providedResult")
    void calculateMatchResults(List<Lotto> lottos, WinningNumber winningNumber,
                               LottoResult lottoResult, int count) throws Exception {
        // when
        Map<LottoResult, Integer> result = matchService.calculateMatchResults(lottos, winningNumber);

        // then
        assertThat(result.get(lottoResult)).isEqualTo(count);
    }

    private static Stream<Arguments> providedResult() {
        return Stream.of(
                arguments(
                        getLottos(List.of(1, 2, 3, 4, 5, 6)),
                        getWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7),
                        LottoResult.SIX, 1),

                arguments(
                        getLottos(List.of(4, 5, 6, 8, 9, 10)),
                        getWinningNumber(List.of(4, 5, 6, 8, 9, 45), 10),
                        LottoResult.FIVE_BONUS, 1),

                arguments(
                        getLottos(List.of(21, 22, 23, 24, 25, 26)),
                        getWinningNumber(List.of(21, 22, 23, 24, 25, 44), 2),
                        LottoResult.FIVE, 1)
        );
    }

    private static List<Lotto> getLottos(List<Integer> number1) {
        return List.of(new Lotto(number1));
    }

    private static WinningNumber getWinningNumber(List<Integer> numbers, int bonus) {
        return new WinningNumber(numbers, bonus);
    }

}