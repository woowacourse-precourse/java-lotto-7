package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}