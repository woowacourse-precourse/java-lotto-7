package lotto.InputValidator;

import lotto.exception.InputErrorMessage;
import lotto.util.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"YOON", "*&!"})
    void 입력금액이_숫자가_아니면_예외발생(String inValidAmount) {
        assertThatThrownBy(() -> InputValidator.validateAmount(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INVALID_NUMERIC_AMOUNT.getMessage()); // 예외 메시지는 실제 메시지로 수정 필요
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000"})
    void 입력금액이_1000원_단위일때_통과한다(String validAmount) {
        InputValidator.validateAmount(validAmount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2500"})
    void 입력금액이_1000원_단위가_아닐때_예외발생(String inValidAmount) {
        assertThatThrownBy(() -> InputValidator.validateAmount(inValidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }
}
