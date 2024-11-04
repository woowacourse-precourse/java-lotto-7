package lotto;

import org.junit.jupiter.api.Test;
import validator.BonusNumberValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberValidatorTest {

    @Test
    void 보너스번호_정상처리일_경우() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BonusNumberValidator.validate(7, winningNumbers);
    }

    @Test
    void 보너스번호가_범위를_벗어날_경우_예외발생() {
        List<Integer> winningnumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> BonusNumberValidator.validate(46, winningnumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_종복될_경우_예외발생() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> BonusNumberValidator.validate(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }
}
