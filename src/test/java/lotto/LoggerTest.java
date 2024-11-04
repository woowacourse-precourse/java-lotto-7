package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class LoggerTest {
    @Test
    void 에러_로그_출력_정상동작() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Logger.error("에러 메세지");

        assertEquals(LogType.ERROR.prefix + " " + "에러 메세지", outputStreamCaptor.toString().trim());

        System.setOut(originalOut);
    }

}