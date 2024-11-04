package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {
    @Test
    @DisplayName("당첨 번호 문자열이 정상적으로 파싱된다")
    void parseValidInput() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = winningNumber.parseInput(input);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 값이 있으면 예외가 발생한다")
    void parseInvalidInput() {
        WinningNumber winningNumber = new WinningNumber();
        String input = "1,2,3,4,5,a";
        assertThatThrownBy(() -> winningNumber.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void validateDuplicateBonusNumber() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.parseAndValidateBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1", "100"})
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
    void validateBonusNumberRange(String input) {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.parseAndValidateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
    }
}