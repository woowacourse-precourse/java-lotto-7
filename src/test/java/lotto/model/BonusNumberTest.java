package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private final BonusNumber bonusNumber = new BonusNumber();

    @Test
    @DisplayName("보너스 번호 입력 유효성 검사")
    void testValidate() {
        assertThatThrownBy(() -> bonusNumber.validate(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> bonusNumber.validate("99"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> bonusNumber.validate(" 1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> bonusNumber.validate("1 2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
