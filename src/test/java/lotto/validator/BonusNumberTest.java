package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 보너스번호_범위_테스트() {
        assertThatThrownBy(() -> new BonusNumber("46").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1이상 45이하의 자연수입니다.");

        assertThatThrownBy(() -> new BonusNumber("0").isNaturalNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1이상 45이하의 자연수입니다.");
    }

    @Test
    void 당첨번호와_겹치는지_테스트() {
        assertThatThrownBy(() -> new BonusNumber("6").isExistedNumber(new WinningNumber("1,2,3,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 중복됩니다.");
    }

}