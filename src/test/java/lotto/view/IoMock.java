package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class IoMock {
    public static InputStream consoleReadLine(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
