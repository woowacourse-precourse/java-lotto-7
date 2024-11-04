package lotto.strategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.NUMBERS_PER_TICKET;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class QuickpickIssuanceStrategyTest {
    private QuickpickIssuanceStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new QuickpickIssuanceStrategy();
    }

    @Nested
    class 로또_번호_발급_테스트 {
        @Test
        void 정해진_개수만큼_번호를_발급한다() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            // when & then
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        Lotto lotto = strategy.issue();
                        assertThat(lotto.getNumbers())
                                .hasSize(NUMBERS_PER_TICKET)
                                .containsExactly(1, 2, 3, 4, 5, 6);
                    },
                    List.of(numbers.toArray(new Integer[0]))
            );
        }

        @Test
        void 발급된_번호는_정렬되어_있다() {
            // given
            List<Integer> numbers = List.of(6, 3, 1, 4, 5, 2);

            // when & then
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        Lotto lotto = strategy.issue();
                        assertThat(lotto.getNumbers())
                                .containsExactly(1, 2, 3, 4, 5, 6)
                                .isSorted();
                    },
                    List.of(numbers.toArray(new Integer[0]))
            );
        }

        @ParameterizedTest
        @MethodSource("provideDifferentValidNumbers")
        void 유효한_범위의_다양한_번호_조합을_발급한다(List<Integer> numbers) {
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        Lotto lotto = strategy.issue();
                        assertThat(lotto.getNumbers())
                                .hasSize(NUMBERS_PER_TICKET)
                                .containsExactlyElementsOf(numbers)
                                .allMatch(n -> n >= MINIMUM_LOTTO_NUMBER && n <= MAXIMUM_LOTTO_NUMBER);
                    },
                    List.of(numbers.toArray(new Integer[0]))
            );
        }

        private static Stream<List<Integer>> provideDifferentValidNumbers() {
            return Stream.of(
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(40, 41, 42, 43, 44, 45),
                    List.of(1, 15, 30, 35, 40, 45),
                    List.of(7, 14, 21, 28, 35, 42)
            );
        }
    }

    @Nested
    class 로또_번호_특성_테스트 {
        @Test
        void 발급된_번호는_중복되지_않는다() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            // when & then
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        Lotto lotto = strategy.issue();
                        assertThat(lotto.getNumbers())
                                .doesNotHaveDuplicates();
                    },
                    List.of(numbers.toArray(new Integer[0]))
            );
        }

        @Test
        void 발급된_번호는_범위_내에_있다() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            // when & then
            assertRandomUniqueNumbersInRangeTest(
                    () -> {
                        Lotto lotto = strategy.issue();
                        assertThat(lotto.getNumbers())
                                .allMatch(number ->
                                        number >= MINIMUM_LOTTO_NUMBER &&
                                                number <= MAXIMUM_LOTTO_NUMBER
                                );
                    },
                    List.of(numbers.toArray(new Integer[0]))
            );
        }
    }
}
