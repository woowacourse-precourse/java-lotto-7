package valid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 검증 테스트")
class ValidationForManyTest {

    @Test
    @DisplayName("로또 번호가 6개이고 정해진 형식을 준수한 경우 true를 반환한다.")
    void consistOfOnlySixPositiveNumbersSuccessCases() {
        //given
        String testInput = "1,2,3,4,5,6";

        //when
        ValidationForMany validationForMany = new ValidationForMany();
        boolean result = validationForMany.consistOfOnlySixPositiveNumbers(testInput);

        //then
        assertEquals(true, result);
    }

    @Test
    @DisplayName("번호가 6개가 아닌 경우 예외")
    void FailedCauseOfLength() {
        //given
        String testInput = "1,2,3,4,5,6,7";
        String testInputTwo = "1,2,3,4,5";

        //when, then
        ValidationForMany validationForMany = new ValidationForMany();

        assertThrows(IllegalArgumentException.class, () -> {
            validationForMany.consistOfOnlySixPositiveNumbers(testInput);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            validationForMany.consistOfOnlySixPositiveNumbers(testInputTwo);
        });
    }

    @Test
    @DisplayName("숫자로만 구성되지 않은 경우 예외")
    void FailedCauseOfNotNumber() {
        //given
        String testInput = "1,2,3,4,5,a";

        //when, then
        ValidationForMany validationForMany = new ValidationForMany();

        assertThrows(IllegalArgumentException.class, () -> {
            validationForMany.consistOfOnlySixPositiveNumbers(testInput);
        });
    }

    @Test
    @DisplayName("0보다 작거나 같은 숫자가 포함된 경우 예외")
    void FailedCauseOfNegativeNumber() {
        //given
        String testInput = "1,2,3,4,5,-1";

        //when, then
        ValidationForMany validationForMany = new ValidationForMany();

        assertThrows(IllegalArgumentException.class, () -> {
            validationForMany.consistOfOnlySixPositiveNumbers(testInput);
        });
    }
}