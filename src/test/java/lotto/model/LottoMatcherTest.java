package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== LottoMatcher 테스트 ==")
public class LottoMatcherTest {
    @ParameterizedTest
    @DisplayName("총 얻은 금액")
    @MethodSource("getTotalEarningArguments")
    void 얻은_금액(WinningLotto winningLotto, List<List<Integer>> randomNumbers, int earned) {
        List<Integer> first = randomNumbers.getFirst();
        List<List<Integer>> rest = randomNumbers.stream()
                .collect(Collectors.toList()); // toList는 unmodifiableList로 변경을 못하기 때문에, collect(Collectors.toList()) 사용
        rest.removeFirst();

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoMatcher lottoMatcher = new LottoMatcher(
                            new Lottos(randomNumbers.size()),
                            winningLotto
                    );

                    assertThat(lottoMatcher.getTotalEarning().toInteger()).isEqualTo(earned);
                },
                first,
                rest.toArray(new List[]{}) // List를 varargs로 바꾸기 위해서
        );
    }

    static Stream<Arguments> getTotalEarningArguments() {
        return Stream.of(
                Arguments.of(
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                        List.of(
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 8, 9, 10)
                        ),
                        2_000_005_000
                ),
                Arguments.of(
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                        List.of(
                                List.of(1, 2, 3, 4, 5, 7),
                                List.of(1, 2, 3, 4, 5, 8),
                                List.of(1, 2, 3, 4, 7, 8)
                        ),
                        31_550_000
                ),
                Arguments.of(
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                        List.of(
                                List.of(1, 2, 3, 7, 8, 9),
                                List.of(1, 2, 3, 10, 11, 12),
                                List.of(1, 2, 3, 4, 7, 8, 9)
                        ),
                        60_000
                ),
                Arguments.of(
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                        List.of(
                                List.of(1, 2, 3, 7, 8, 9),
                                List.of(1, 2, 3, 10, 11, 12),
                                List.of(1, 2, 3, 4, 7, 8, 9)
                        ),
                        60_000
                ),
                Arguments.of(
                        new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7),
                        List.of(
                                List.of(7, 8, 9, 10, 11, 12)
                        ),
                        0
                )
        );
    }
}
