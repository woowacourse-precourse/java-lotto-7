package lotto.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.WinningNumberRequestDTO;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @Test
    @DisplayName("정확한 당첨 번호 객체를 생성한다.")
    public void winningNumber() {
        // GIVEN
        WinningNumberRequestDTO request = new WinningNumberRequestDTO("1,2,3,4,5,6");

        // WHEN
        WinningNumbers winningNumbers = new WinningNumbers(request);

        // THEN
        assertThat(winningNumbers.getWinningNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 개수가 6개가 아닌 경우, 예외를 발생시킨다.")
    public void winningNumberCount() {
        // GIVEN
        WinningNumberRequestDTO request = new WinningNumberRequestDTO("1,2,3,4,5");

        // WHEN - THEN
        assertThatThrownBy(() -> new WinningNumbers(request)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 범위에 해당하지 않는 경우, 예외를 발생시킨다.")
    public void winningNumberRange() {
        // GIVEN
        WinningNumberRequestDTO request = new WinningNumberRequestDTO("1,2,3,4,5,46");

        // WHEN - THEN
        assertThatThrownBy(() -> new WinningNumbers(request)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 중복되는 경우, 예외를 발생시킨다.")
    public void winningNumberDuplicate() {
        // GIVEN
        WinningNumberRequestDTO request = new WinningNumberRequestDTO("1,2,3,4,5,5");

        // WHEN - THEN
        assertThatThrownBy(() -> new WinningNumbers(request)).isInstanceOf(IllegalArgumentException.class);
    }
}
