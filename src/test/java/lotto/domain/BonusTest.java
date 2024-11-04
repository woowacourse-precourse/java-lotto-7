package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.bonus.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @Test
    @DisplayName("1~45 사이를 벗어난 보너스 번호 입력 테스트")
    void 입력된_번호가_1부터_45_사이에_속하지_않은_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Bonus(46))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Bonus(0))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> new Bonus(-1))
                .withMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
