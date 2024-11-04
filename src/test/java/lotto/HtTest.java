package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

public class HtTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream captor;

    @BeforeEach
    void setUp() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }
    @AfterEach
    void setAfter() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }


    protected final void input(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected final String output() {
        return captor.toString().trim();

    }
}
