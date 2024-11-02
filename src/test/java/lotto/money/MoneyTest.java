package lotto.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("돈은 마이너스가 불가능함")
    @Test
    void test() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }
}