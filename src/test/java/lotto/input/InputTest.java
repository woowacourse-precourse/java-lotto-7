package lotto.input;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.message.InputMessage;
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
}
