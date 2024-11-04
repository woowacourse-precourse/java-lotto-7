package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommonInputValidatorTest {

    private CommonInputValidator commonInputValidator;

    @BeforeEach
    void beforeEach() {
        this.commonInputValidator = new CommonInputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "1, 2, 3, 4, 5, 6", " 1", "1 "})
    void 입력_값에_공백이_포함_되었을_때의_예외_테스트(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> commonInputValidator.validateCommonInput(input),
                "입력값에 공백이 포함되면 예외가 발생해야 합니다.");
    }

    @Test
    void 입력_값이_Null일_경우의_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> commonInputValidator.validateCommonInput(""),
                "입력값이 null이면 예외가 발생해야 합니다.");
    }
}
