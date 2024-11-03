package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.view.ValidatorOfView.isValidWinningNumber;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumberValidationTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> isValidWinningNumber(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> isValidWinningNumber(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("로또 번호 중 범위 밖의 수가 있으면 예외가 발생한다.")
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> isValidWinningNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> isValidWinningNumber(List.of(1,2,3,4,6,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
