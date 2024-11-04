package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = Lotto.issue(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.issue(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호", "6");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.issue(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호", "중복");
    }

    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_1부터_45사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.issue(List.of(0, 1, 2, 3, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호", "1", "45");
    }

    @DisplayName("로또는 다른 로또와 비교해 일치하는 숫자의 개수를 계산할 수 있다.")
    @MethodSource(value = "provideOtherLottoAndExpectedMatchingCount")
    @ParameterizedTest
    void 다른_로또와_일치하는_로또_번호_개수_계산(Lotto other, int expectedMatchingCount) {
        assertThat(lotto.calculateMatchingCount(other)).isEqualTo(expectedMatchingCount);
    }

    @DisplayName("로또는 주어진 번호의 포함 여부를 알려준다.")
    @MethodSource(value = "provideLottoBallAndExpectedHas")
    @ParameterizedTest
    void 로또_번호_포함_여부(LottoBall lottoBall, boolean expectedHas) {
        assertThat(lotto.has(lottoBall)).isEqualTo(expectedHas);
    }

    static Stream<Arguments> provideOtherLottoAndExpectedMatchingCount() {
        return Stream.of(
                Arguments.of(Lotto.issue(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(Lotto.issue(List.of(1, 2, 3, 4, 5, 10)), 5),
                Arguments.of(Lotto.issue(List.of(1, 2, 3, 4, 10, 11)), 4),
                Arguments.of(Lotto.issue(List.of(1, 2, 3, 10, 11, 12)), 3),
                Arguments.of(Lotto.issue(List.of(10, 11, 12, 13, 14, 15)), 0)
        );
    }

    static Stream<Arguments> provideLottoBallAndExpectedHas() {
        return Stream.of(
                Arguments.of(LottoBall.draw(1), true),
                Arguments.of(LottoBall.draw(10), false)
        );
    }

}
