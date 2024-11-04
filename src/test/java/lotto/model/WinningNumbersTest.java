package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.exception.CustomLottoException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    void 당첨_번호가_6개가_아닌_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
    void 당첨_번호에_중복된_숫자가_있는_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 2, 4, 5, 6), 7))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복된 경우 예외가 발생한다.")
    void 당첨_번호와_보너스_번호가_중복된_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("당첨 번호가 1 ~ 45 범위를 벗어난 경우 예외가 발생한다.")
    void 당첨_번호가_범위를_벗어난_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 범위를 벗어난 경우 예외가 발생한다.")
    void 보너스_번호가_범위를_벗어난_경우_예외() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(CustomLottoException.class)
                .hasMessageContaining("[ERROR] 번호는 1 ~ 45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 올바른 경우 객체가 성공적으로 생성된다.")
    void 당첨_번호와_보너스_번호가_올바른_경우_객체_생성() {
        List<Integer> validWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(validWinningNumbers, validBonusNumber);
        assertThat(winningNumbers.winningNumbers()).containsExactlyElementsOf(validWinningNumbers);
        assertThat(winningNumbers.bonusNumber()).isEqualTo(validBonusNumber);
    }
}