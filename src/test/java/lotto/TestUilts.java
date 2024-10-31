package lotto;

import java.io.ByteArrayInputStream;

class TestUtils {
    static void setInputStream(String dummyInput) {
        System.setIn(new ByteArrayInputStream(dummyInput.getBytes()));
    }
}