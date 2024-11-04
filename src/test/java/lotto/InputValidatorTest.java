package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.util.InputValidator;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Test
    void validateAmount_validAmount() {
        assertThatCode(() -> inputValidator.validateAmount(5000))
                .doesNotThrowAnyException();
    }

    @Test
    void validateAmount_zeroOrNegative() {
        assertThatCode(() -> inputValidator.validateAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");

        assertThatCode(() -> inputValidator.validateAmount(-500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
    }

    @Test
    void validateAmount_underMinimumAmount() {
        assertThatCode(() -> inputValidator.validateAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
    }

    @Test
    void validateAmount_exceedMaximumAmount() {
        assertThatCode(() -> inputValidator.validateAmount(150000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 최대 100,000원까지 가능합니다.");
    }

    @Test
    void validateAmount_NonDivisibleBy1000() {
        assertThatCode(() -> inputValidator.validateAmount(5500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위이어야 합니다.");
    }
}
