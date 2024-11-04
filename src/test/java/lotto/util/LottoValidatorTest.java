package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoValidatorTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 발생")
    void purchaseAmountNotThousandUnit() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아니면 예외 발생")
    void purchaseAmountNotNumeric() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호에 중복이 있으면 예외 발생")
    void winningNumbersHaveDuplicates() {
        assertThatThrownBy(() -> LottoValidator.parseLottoNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외 발생")
    void winningNumbersSizeNotSix() {
        assertThatThrownBy(() -> LottoValidator.parseLottoNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외 발생")
    void bonusNumberNotNumeric() {
        assertThatThrownBy(() -> LottoValidator.parseBonusNumber("abc", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}