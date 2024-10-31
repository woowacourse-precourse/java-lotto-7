package lotto.view.input.validator;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    private static final String BLANK = "";
    private static final String CHAR = "character";

    @Test
    @DisplayName("입력 예외 Money")
    void inputMoneyTest() {
        List<String> exceptionData = List.of(BLANK, CHAR);
        verifyException(exceptionData, InputValidator::moneyValidate, ErrorMessage.NUMBER_REGEX_PATTERN);
    }

    @Test
    @DisplayName("입력 예외 BonusNumber")
    void inputBonusNumberTest() {
        List<String> exceptionData = List.of(BLANK, CHAR);
        verifyException(exceptionData, InputValidator::bonusNumberValidate, ErrorMessage.NUMBER_REGEX_PATTERN);
    }

    @Test
    @DisplayName("입력 예외 WinningLotto")
    void inputWinningLottoTest() {
        List<String> exceptionData = List.of(
                BLANK, CHAR, "1,,2,,3,,4,,5,,6", "1,2,3,4,5,6,",
                ",2,3,4,5,6", "1.2.3.4.5.6", "1 ,2,3,4,5,6",
                "1,2,3,4,5,6 "
        );
        verifyException(exceptionData, InputValidator::winningLottoValidate, ErrorMessage.LOTTO_REGEX_PATTERN);
    }


    private void verifyException(List<String> exceptionData, Consumer<String> validate, ErrorMessage errorMessage) {
        exceptionData.forEach((data) -> {
            assertThatThrownBy(() -> validate.accept(data))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(errorMessage.getMessage());
        });
    }
}
