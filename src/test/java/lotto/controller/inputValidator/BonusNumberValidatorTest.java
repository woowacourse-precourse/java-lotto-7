package lotto.controller.inputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    @Test
    void 보너스번호가_공백일_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                BonusNumberValidator.validate(" ", List.of(1, 2, 3, 4, 5, 6))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호를 입력해주세요.");
    }

    @Test
    void 보너스번호가_숫자가_아닐_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                BonusNumberValidator.validate("abc", List.of(1, 2, 3, 4, 5, 6))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복될_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                BonusNumberValidator.validate("3", List.of(1, 2, 3, 4, 5, 6))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨번호와 중복된 숫자가 있을 수 없습니다.");
    }

    @Test
    void 보너스번호가_범위를_벗어난_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                BonusNumberValidator.validate("50", List.of(1, 2, 3, 4, 5, 6))
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스번호가_유효한_경우_정상적으로_변환되어야_한다() {
        Integer result = BonusNumberValidator.validate("7", List.of(1, 2, 3, 4, 5, 6));
        assertEquals(7, result);
    }
}