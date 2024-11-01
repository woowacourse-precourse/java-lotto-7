package lotto.common.constant;

import static lotto.common.constant.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorMessagesTest {
    @Test
    @DisplayName("에러메세지는 반드시 접두사([ERROR])를 포함한다")
    void errorMessagesShouldStartWithPrefix() {
        String prefix = "[ERROR]";
        String message1 = String.valueOf(BLANK_NOT_ALLOWED);
        String message2 = String.valueOf(DUPLICATED);
        String message3 = String.valueOf(MUST_BE_WHOLE_NUMBER);

        assertThat(message1).startsWith(prefix);
        assertThat(message2).startsWith(prefix);
        assertThat(message3).startsWith(prefix);
    }
}
