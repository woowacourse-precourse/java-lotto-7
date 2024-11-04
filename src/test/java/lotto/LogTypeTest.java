package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogTypeTest {
    @Test
    void 에러_접두사_정상동작() {
        Assertions.assertEquals(LogType.ERROR.prefix, "[ERROR]");
    }

}