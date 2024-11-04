package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호로 WinningNumbers 객체가 제대로 생성되는지 확인")
    void testWinningNumbersCreation() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int bonusNumber = 7;

        WinningNumbers winningNumber = new WinningNumbers(winningNumbers, bonusNumber);

        assertThat(winningNumber.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 때 예외 처리")
    void testInvalidWinningNumbersSize() {
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5); // 5개만 입력

        assertThatThrownBy(() -> new WinningNumbers(invalidWinningNumbers, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 처리")
    void testDuplicateBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 6; // 중복된 번호

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, duplicateBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }
}