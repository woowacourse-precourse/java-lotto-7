package lotto.util.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMatchingCountCalculatorTest {

    LottoMatchingCountCalculator lottoMatchingCountCalculator;

    @BeforeEach
    void setUp() {
        lottoMatchingCountCalculator = new LottoMatchingCountCalculator();
    }

    @ParameterizedTest
    @MethodSource("countMatchingNumbers")
    void 두_로또의_번호가_일치하는_수를_계산한다(Lotto lotto1, Lotto lotto2, int expected) {
        int countMatchingNumbers
                = lottoMatchingCountCalculator.countMatchingNumbers(lotto1, lotto2);
        assertThat(countMatchingNumbers).isEqualTo(expected);
    }

    public static Stream<Arguments> countMatchingNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(lotto, new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(lotto, new Lotto(List.of(11, 22, 33, 4, 5, 6)), 3),
                Arguments.of(lotto, new Lotto(List.of(12, 23, 13, 41, 25, 34)), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("isMatchingNumber")
    void 로또_번호와_특정_번호가_일치하는_지를_확인한다(int number, Lotto lotto, boolean expected) {
        boolean matchingNumber = lottoMatchingCountCalculator.isMatchingNumber(number, lotto);
        assertThat(matchingNumber).isEqualTo(expected);
    }

    public static Stream<Arguments> isMatchingNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(1, lotto, true),
                Arguments.of(6, lotto, true),
                Arguments.of(7, lotto, false),
                Arguments.of(43, lotto, false)
        );
    }

}