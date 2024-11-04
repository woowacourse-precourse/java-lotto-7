package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class inputTest {

    @Test
    @DisplayName("정상적인 금액 입력 시 구매 가능한 로또 개수 확인")
    public void testValidMoneyInput() {
        input input = new input();
        int money = 5000;
        int count = input.try_number(money);
        assertEquals(5, count, "5000원을 입력하면 5개의 로또를 구매할 수 있어야 합니다.");
    }

    @Test
    @DisplayName("문자 입력 시 예외 발생 확인")
    public void testNonNumericInput() {
        input input = new input();
        String invalidInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            input.paymentEx2(invalidInput);
        });

        assertEquals("[ERROR] 숫자만 입력해주세요.", exception.getMessage(), "숫자가 아닌 입력에 대해 올바른 예외 메시지가 출력되어야 합니다.");
    }

    @Test
    @DisplayName("숫자 입력 시 정상 처리 확인")
    public void testNumericInput() {
        input input = new input();
        String validInput = "3000";

        assertDoesNotThrow(() -> input.paymentEx2(validInput), "숫자 입력은 예외를 발생시키지 않아야 합니다.");
    }
}