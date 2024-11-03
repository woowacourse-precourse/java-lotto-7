package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LottoGradeTest {

    @ParameterizedTest
    @MethodSource("provideLottoGrades")
    void 로또_등급_테스트(int targetCount, int bonusCount, LottoGrade expectedGrade) {
        LottoGrade lottoGrade = LottoGrade.findBy(targetCount, bonusCount);

        Assertions.assertThat(lottoGrade).isEqualTo(expectedGrade);
    }

    @DisplayName("값에 따라 정확한 등수를 반환하는지, 보너스는 2등과 3등을 가르는 데에만 사용되는지를 테스트")
    private static Stream<Arguments> provideLottoGrades() {
        return Stream.of(
                Arguments.of(6, 0, LottoGrade.FIRST),
                Arguments.of(6, 1, LottoGrade.FIRST),
                Arguments.of(5, 1, LottoGrade.SECOND),
                Arguments.of(5, 0, LottoGrade.THIRD),
                Arguments.of(4, 0, LottoGrade.FORTH),
                Arguments.of(4, 1, LottoGrade.FORTH),
                Arguments.of(3, 0, LottoGrade.FIFTH),
                Arguments.of(3, 1, LottoGrade.FIFTH),
                Arguments.of(2, 0, LottoGrade.FAIL),
                Arguments.of(2, 1, LottoGrade.FAIL),
                Arguments.of(0, 0, LottoGrade.FAIL),
                Arguments.of(0, 1, LottoGrade.FAIL)
        );
    }

    @Test
    void 로또_등급_예외테스트() {
        Assertions.assertThatThrownBy(() -> LottoGrade.findBy(7, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
