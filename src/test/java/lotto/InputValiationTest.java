package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.controller.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class InputValiationTest {
    private InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @NullAndEmptySource
    void 금액_널_체크(String input) {
        assertThatThrownBy(() -> inputValidation.checkInputNull(input))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @CsvSource({"5", "12345","0"})
    void 금액_단위_검증(Long input) {
        assertThatThrownBy(() -> inputValidation.checkUnitOfMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"한글", "123h45","-123"})
    void 금액_양식_확인(String input) {
        assertThatThrownBy(() -> inputValidation.checkMoneyForm(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
