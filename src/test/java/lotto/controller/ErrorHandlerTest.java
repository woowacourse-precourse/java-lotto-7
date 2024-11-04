package lotto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ErrorHandlerTest {

    private ErrorHandler errorHandler;
    private OutputView outputView;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        errorHandler = new ErrorHandler(outputView);
        System.setOut(new PrintStream(outputStreamCaptor)); // System.out 출력을 캡처
    }

    @Test
    void accept_예외발생시_에러메시지출력() {
        //given
        Exception exception = new IllegalArgumentException("Invalid input");

        //when
        errorHandler.accept(exception);

        //then
        String expectedOutput = "[ERROR] Invalid input";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim()); // 캡처된 출력값 검증
    }

}