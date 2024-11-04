package lotto.model;

import lotto.mock.number_generator.ChoosableRandomNumberMaker;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Score 테스트")
public class ScoreTest {

    static Stream<Arguments> 로또_당첨_통계를_반환한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7),
                        Score.SIX
                ),
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(1, 2, 3, 4, 5, 7), 6),
                        Score.FIFTH_WITH_BONUS
                ),
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(1, 2, 3, 4, 5, 8), 9),
                        Score.FIFTH
                ),
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(1, 2, 3, 4, 7, 8), 9),
                        Score.FOURTH
                ),
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(1, 2, 3, 7, 8, 9), 10),
                        Score.THREE
                ),
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(1, 2, 7, 8, 9, 10), 11),
                        Score.ZERO
                ),
                Arguments.of(
                        Lotto.generate(new ChoosableRandomNumberMaker(List.of(1, 2, 3, 4, 5, 6))),
                        createWinningLotto(List.of(7, 8, 9, 10, 11, 12), 13),
                        Score.ZERO
                )
        );
    }

    static Stream<Arguments> 당첨_통계를_집계한다_테스트_케이스() {
        return Stream.of(
                Arguments.of(
                        List.of(Score.SIX, Score.FIFTH_WITH_BONUS, Score.FIFTH, Score.FOURTH, Score.THREE, Score.ZERO, Score.ZERO),
                        Map.of(
                                Score.SIX, 1,
                                Score.FIFTH_WITH_BONUS, 1,
                                Score.FIFTH, 1,
                                Score.FOURTH, 1,
                                Score.THREE, 1,
                                Score.ZERO, 2
                        )
                ),
                Arguments.of(
                        List.of(Score.SIX, Score.FIFTH, Score.FIFTH, Score.THREE, Score.FIFTH_WITH_BONUS, Score.ZERO),
                        Map.of(
                                Score.SIX, 1,
                                Score.FIFTH_WITH_BONUS, 1,
                                Score.FIFTH, 2,
                                Score.FOURTH, 0,
                                Score.THREE, 1,
                                Score.ZERO, 1
                        )
                )
        );
    }

    private static WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        LottoNumbers winningNumbers = LottoNumbers.from(lottoNumbers);

        return new WinningLotto(winningNumbers, LottoNumber.from(bonusNumber));
    }

    @ParameterizedTest(name = "lotto : {0}, winningLotto : {1}, expected : {2}")
    @MethodSource("로또_당첨_통계를_반환한다_테스트_케이스")
    void 로또_당첨_통계를_반환한다(Lotto lotto, WinningLotto winningLotto, Score expected) {

        // when
        Score actual = Score.calculateScore(lotto, winningLotto);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "scores : {0}, expected : {1}")
    @MethodSource("당첨_통계를_집계한다_테스트_케이스")
    void 당첨_통계를_집계한다(List<Score> scores, Map<Score, Integer> expected) {

        // when
        Map<Score, Integer> actual = Score.aggregate(scores);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
