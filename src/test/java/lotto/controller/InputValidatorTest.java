package lotto.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @CsvSource({"1001", "-1", "100", "1500", "15100"})
    void 구입금액이_1000_단위가_아닌경우_예외가_발생한다(String money) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 단위로 입력해야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({"2121301000000", "321342100001000"})
    void 구입금액이_너무_큰_금액이라면_예외가_발생한다(String money) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 2100000000까지 입력가능합니다.");
    }

    @ParameterizedTest
    @CsvSource({"1000j", "dwad"})
    void 구입금액이_숫자가_아닌경우_예외가_발생한다(String money) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아니거나, long의 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 구입금액이_공백인_경우_예외가_발생한다(String money) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아니거나, long의 범위를 벗어났습니다.");
    }
}