package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class IllegalArgumentHandlerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private int count = 0;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("handler를 통해 제어되는 부분에서 IllegalArgumentException을 반환하지 않는지 확인")
    @Test
    void testDoUntilNoOccur() {
        IllegalArgumentHandler<Integer> illegalArgumentHandler = new IllegalArgumentHandler<>();

        assertDoesNotThrow(() -> illegalArgumentHandler.doUntilNoOccur(throwIllegalArgumentExceptionCountOf(1)));
    }

    @DisplayName("IllegalArgumentException 발생 시 [ERROR]로 시작하는 문구가 출력되는지 확인")
    @Test
    void testDoUntilNoOccurErrorMessage() {
        IllegalArgumentHandler<Integer> illegalArgumentHandler = new IllegalArgumentHandler<>();
        illegalArgumentHandler.doUntilNoOccur(throwIllegalArgumentExceptionCountOf(1));

        assertThat(outputStreamCaptor.toString()).contains("[ERROR]");
    }

    private Supplier<Integer> throwIllegalArgumentExceptionCountOf(int repeat) {
        count = 0;
        return () -> {
            if (count == repeat) {
                return 0;
            }
            count++;
            throw new IllegalArgumentException();
        };
    }
}