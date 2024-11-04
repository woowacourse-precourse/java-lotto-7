package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    private final InputStream inputStream = System.in;
    private InputReader inputReader = new InputReader();

    @BeforeEach
    void setUp(){
        String testString = "14000";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
    }
    @AfterEach
    void rollBack(){
        System.setIn(inputStream);
    }

    @Test
    void readUserInputTest(){
        String input = inputReader.readUserInput();
        assertEquals("14000", input);
    }
}