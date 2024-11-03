package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class IllegalArgumentHandlerTest {
    private int count = 0;

    @DisplayName("handler를 통해 제어되는 부분에서 IllegalArgumentException을 반환하지 않는지 확인")
    @Test
    void doUntilNoOccur() {
        IllegalArgumentHandler illegalArgumentHandler = new IllegalArgumentHandler();
        Supplier<Integer> throwOneIllegalArgument = () -> {
            if (count == 1) {
                return 0;
            }
            count++;
            throw new IllegalArgumentException();
        };

        assertDoesNotThrow(() -> illegalArgumentHandler.doUntilNoOccur(() -> throwOneIllegalArgument));
    }
}