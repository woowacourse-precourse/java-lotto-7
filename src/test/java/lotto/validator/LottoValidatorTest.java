package lotto.validator;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {
    private LottoValidator lottoValidator;

    @BeforeEach
    void setup() {
        lottoValidator = new LottoValidator();
    }

    @DisplayName("빈 칸이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validate(input));
        assertEquals(ExceptionMessage.NOT_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("숫자와 콤마외에는 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {",234,5", "23,a34", "534,4a5", "2,,334", "123,34,", "13, 34 ,33"})
    void validateFormat_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validate(input));
        assertEquals(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage(), exception.getMessage());
    }

    @DisplayName("로또 숫자의 범위를 초과하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"46,47,48", "50,100", "46,0,49", "-1,3,34"})
    void validateNumberRange_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validate(input));
        assertEquals(ExceptionMessage.OUT_OF_RANGE.getMessage(), exception.getMessage());
    }


    @DisplayName("중복되는 숫자가 있다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3,3,3,3,5,7", "1,1,2,3,4,5,34", "33,44,5,6,6,7"})
    void validateDuplicateNumber_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validate(input));
        assertEquals(ExceptionMessage.DUPLICATE_NUMBER.getMessage(), exception.getMessage());
    }
}