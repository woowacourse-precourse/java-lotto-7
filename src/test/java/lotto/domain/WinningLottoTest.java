package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 1~45 사이가 아닌 경우 예외 발생")
    @ValueSource(ints = {0, -1, 46, 100})
    void 보너스_번호가_1_45_사이가_아닌_경우_예외_발생(int bonusNumber) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winningNumbers, bonusNumber),
                "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 발생")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스_번호가_당첨_번호와_중복되는_경우_예외_발생(int bonusNumber) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(winningNumbers, bonusNumber),
                "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 1~45 사이이며 당첨 번호와 중복되지 않는 경우 예외 발생하지 않음")
    @ValueSource(ints = {7, 20, 45})
    void 유효한_보너스_번호일_때_예외_미발생(int bonusNumber) {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> new WinningLotto(winningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource("provideLottoAndRank")
    @DisplayName("로또 당첨 결과가 정상적으로 반환되는지 테스트")
    void 로또_당첨_결과_테스트(List<Integer> numbers, Rank expectedRank) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(numbers);
        Rank resultRank = winningLotto.determineRank(lotto);
        assertThat(resultRank).isEqualTo(expectedRank);
    }

    private static List<Object[]> provideLottoAndRank() {
        return List.of(
                new Object[]{List.of(1, 2, 3, 4, 5, 6), Rank.FIRST_PLACE},
                new Object[]{List.of(1, 2, 3, 4, 5, 7), Rank.SECOND_PLACE},
                new Object[]{List.of(1, 2, 3, 4, 5, 40), Rank.THIRD_PLACE},
                new Object[]{List.of(1, 2, 3, 4, 40, 41), Rank.FOURTH_PLACE},
                new Object[]{List.of(1, 2, 3, 40, 41, 42), Rank.FIFTH_PLACE},
                new Object[]{List.of(1, 2, 40, 41, 42, 43), Rank.MISS}
        );
    }
}