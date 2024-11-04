package lotto;

import org.junit.jupiter.api.Test;
import validator.WinningNumbersValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersValidatorTest {

    @Test
    void 올바른_당첨_번호_입력일_경우_정상_처리() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbersValidator.validate(winningNumbers);
    }

    @Test
    void 입력한_당첨_번호가_범위를_벗어날_경우_예외발생() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 입력한_당첨_번호에_중복이_있을_경우_예외발생() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(List.of(1, 2, 3, 4, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
    }

    @Test
    void 입력한_당첨_번호가_6개가_아닐_경우_예외발생() {
        assertThatThrownBy(() -> WinningNumbersValidator.validate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
    }
}


