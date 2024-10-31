package lotto.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.message.InputMessage;
import lotto.validate.InputValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    @DisplayName("구입금액을 입력하라는 메시지가 정상출력된다.")
    public void testDisplayRequestInputAmount() {
        // given
        String message = InputMessage.REQUEST_INPUT_AMOUNT.getMessage();

        // then
        assertEquals(message, "구입금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("구입금액은 숫자 문자열만 가능하다.")
    public void testValidateRequestNumberInput() {
        // given
        String input = "123";

        // when
        boolean result = InputValidate.isNumeric(input);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("구입금액은 숫자 문자열이 아니라면 불가능하다.")
    public void testValidateRequestNonNumberInput() {
        // given
        String input = "test";

        // when
        boolean result = InputValidate.isNumeric(input);

        // then
        assertFalse(result);
    }
}
