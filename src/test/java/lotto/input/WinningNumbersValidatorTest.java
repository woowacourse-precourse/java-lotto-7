package lotto.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.enums.ErrorMessages.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersValidatorTest {
    private WinningNumbersValidator winningNumbersValidator;

    @BeforeEach
    void setUp() {
        winningNumbersValidator = new WinningNumbersValidator();
    }

    @Test
    @DisplayName("입력이 유효한 경우 당첨 번호 반환 테스트")
    void InputValid() {
        //given
        String input = "1,2,3,4,5,6";
        List<Integer> actualInput = List.of(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> expectedInput = winningNumbersValidator.validateInput(input, null);

        //then
        Assertions.assertThat(actualInput).isEqualTo(expectedInput);
    }

    @Test
    @DisplayName("숫자와 구분자 이외의 문자가 입력될 경우 예외 발생 테스트")
    void InputInValidDelimiter() {
        String input = "1,2+3-4$5*6";

        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateInput(input, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUMBER_DELIMITER.getMessage());
    }

    @Test
    @DisplayName("로또 당첨 번호가 범위(1~45)를 벗어날 경우 예외 발생 테스트")
    void winningNumberIsOutOfRange() {
        String input = "0,2,3,4,5,46";

        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateInput(input, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("로또 당첨 번호가 6개 입력되지 않으면 예외 발생 테스트")
    void winningNumberIsInvalidSize() {
        String input = "1,2,3,4,5";

        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateInput(input, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUMBER_SIZE.getMessage());
    }

    @Test
    @DisplayName("로또 당첨 번호가 중복 될 시 예외 발생 테스트")
    void winningNumberIsDuplicate() {
        String input = "1,1,2,3,4,5";

        Assertions.assertThatThrownBy(() -> winningNumbersValidator.validateInput(input, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_WINNING_NUMBER.getMessage());
    }
}