package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class WinningNumberInputTest {

    private WinningNumberInput inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new WinningNumberInput();
    }

    @Test
    void parseWinningNumbers_validInput() {
        // 직접 테스트용 메서드를 호출하여 유효성 검증
        List<Integer> numbers = inputHandler.parseWinningNumbers("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void parseWinningNumbers_invalidSize_throwsException() {
        assertThatThrownBy(() -> inputHandler.parseWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 6개의 숫자여야 합니다.");
    }

    @Test
    void parseWinningNumbers_outOfRangeNumber_throwsException() {
        assertThatThrownBy(() -> inputHandler.parseWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void parseWinningNumbers_duplicateNumber_throwsException() {
        assertThatThrownBy(() -> inputHandler.parseWinningNumbers("1,2,3,3,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 입력되었습니다.");
    }

    @Test
    void validateBonusNumber_duplicateWithWinningNumbers_throwsException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputHandler.validateBonusNumber("3", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    void validateBonusNumber_outOfRangeNumber_throwsException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputHandler.validateBonusNumber("50", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}