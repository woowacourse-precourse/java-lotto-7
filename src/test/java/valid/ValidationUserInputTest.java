package valid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUserInputTest {

    @Test
    @DisplayName("사용자 입력 정상")
    void validateMoneySuccessCase() {
        //given
        String testInput = "1000";

        //when
        ValidationUserInput validationUserInput = new ValidationUserInput();
        Integer money = validationUserInput.validateMoney(testInput);

        //then
        assertEquals(1000, money);
    }

    @Test
    @DisplayName("사용자가 돈에 음수값 입력시 예외 발생")
    void validateMoneyFailedCase() {
        //given
        String testInput = "-1000";

        //when, then
        ValidationUserInput validationUserInput = new ValidationUserInput();

        assertThrows(IllegalArgumentException.class, () -> {
            validationUserInput.validateMoney(testInput);
        });
    }

    @Test
    @DisplayName("사용자가 돈에 문자 입력시 예외 발생")
    void validateMoneyFailedCase2() {
        //given
        String testInput = "1000a";

        //when, then
        ValidationUserInput validationUserInput = new ValidationUserInput();

        assertThrows(IllegalArgumentException.class, () -> {
            validationUserInput.validateMoney(testInput);
        });
    }

    @Test
    @DisplayName("사용자 입력 돈이 1000원 단위가 아닌 경우 예외 발생")
    void validateMoneyFailedCase3() {
        //given
        String testInput = "1234";

        //when, then
        ValidationUserInput validationUserInput = new ValidationUserInput();

        assertThrows(IllegalArgumentException.class, () -> {
            validationUserInput.validateMoney(testInput);
        });
    }
}