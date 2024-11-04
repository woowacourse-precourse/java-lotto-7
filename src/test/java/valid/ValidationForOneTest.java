package valid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationForOneTest {

    @Test
    @DisplayName("양수값 정상 입력 케이스")
    void consistOfOnlyPositiveNumbersSuccessCase() {
        //given
        String testInput = "1000";

        //when
        ValidationForOne validationForOne = new ValidationForOne();
        Integer money = validationForOne.consistOfOnlyPositiveNumbers(testInput);

        //then
        assertEquals(1000, money);
    }

    @Test
    @DisplayName("0보다 작은 값 입력시 예외 발생")
    void FailedCauseOfNegativeNumber() {
        //given
        String testInput = "-1000";

        //when, then
        ValidationForOne validationForOne = new ValidationForOne();

        assertThrows(IllegalArgumentException.class, () -> {
            validationForOne.consistOfOnlyPositiveNumbers(testInput);
        });
    }

    @Test
    @DisplayName("숫자 + 문자인 경우 예외 발생")
    void FailedCauseOfNotNumber() {
        //given
        String testInput = "1000a";

        //when, then
        ValidationForOne validationForOne = new ValidationForOne();

        assertThrows(IllegalArgumentException.class, () -> {
            validationForOne.consistOfOnlyPositiveNumbers(testInput);
        });
    }

    @Test
    @DisplayName("1000원 단위로 정상 입력 케이스")
    void devisibleByThousandsSuccessCase() {
        //given
        Integer testInput = 100000;

        //when
        ValidationForOne validationForOne = new ValidationForOne();
        boolean result = validationForOne.devisibleByThousands(testInput);

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("1000원 단위로 입력하지 않은 경우 예외 발생")
    void FailedCauseOfNotDevisibleByThousands() {
        //given
        Integer testInput = 123456;

        //when, then
        ValidationForOne validationForOne = new ValidationForOne();

        assertThrows(IllegalArgumentException.class, () -> {
            validationForOne.devisibleByThousands(testInput);
        });
    }
}