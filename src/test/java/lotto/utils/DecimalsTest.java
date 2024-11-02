package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DecimalsTest {
    @Test
    void 반올림_기능_테스트() {
        assertEquals(Decimals.round(10.15, 1), 10.2);
        assertEquals(Decimals.round(10.151, 2), 10.15);
        assertEquals(Decimals.round(10.0007, 3), 10.001);
    }

    @DisplayName("유효하지 않은 소수점 자리 값을 입력하면 예외가 발생한다.")
    @Test
    void 반올림_기능_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Decimals.round(10.15, 0));
        assertThrows(IllegalArgumentException.class, () -> Decimals.round(10.15, -1));
    }
}
