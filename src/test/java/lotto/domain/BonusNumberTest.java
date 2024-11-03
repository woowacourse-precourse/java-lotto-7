package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled
public class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void shouldThrowExceptionWhenBonusIsOutOfRange(int bonus) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void shouldThrowExceptionWhenBonusIsDuplicate() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningNumbers(winningNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 올바를 때 WinningNumbers 객체가 정상적으로 생성된다.")
    @Test
    void shouldCreateWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningTicket = new WinningNumbers(winningNumbers, 7);

        assertThat(winningTicket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(7);
    }


}
