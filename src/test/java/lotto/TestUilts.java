package lotto;

import java.io.ByteArrayInputStream;

class TestUtils {
    static void setInputStream(final String... args) {

        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}