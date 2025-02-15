package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않고 유효한 범위에 있을 경우")
    @Test
    void 보너스번호_유효성_검사() {
        List<Integer> winningNumbers = Arrays.asList(3, 11, 23, 29, 35, 42);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(5, winningNumber);

        assertThat(bonusNumber.getBonus()).isEqualTo(5);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    @Test
    void 보너스번호_중복_예외() {
        List<Integer> winningNumbers = Arrays.asList(3, 11, 23, 29, 35, 42);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        assertThatThrownBy(() -> new BonusNumber(3, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 예외 발생")
    @Test
    void 보너스번호_범위_예외() {
        List<Integer> winningNumbers = Arrays.asList(3, 11, 23, 29, 35, 42);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        assertThatThrownBy(() -> new BonusNumber(46, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호가 범위를 벗어납니다.");
    }

    @DisplayName("보너스 번호가 null일 경우 예외 발생")
    @Test
    void 보너스번호_null_예외() {
        List<Integer> winningNumbers = Arrays.asList(3, 11, 23, 29, 35, 42);
        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        assertThatThrownBy(() -> new BonusNumber(null, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호를 입력해주세요");
    }
}