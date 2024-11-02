package lotto.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberUtilTest {

    @Test
    void 양수_입력시_양수_반환() {
        int result = NumberUtil.parsePositiveNumber("1000");
        assertEquals(1000, result);
    }

    @Test
    void 제로_입력시_예외발생() {
        int result = NumberUtil.parsePositiveNumber("0");
        assertEquals(0, result);
    }

    @Test
    void 음수_입력시_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberUtil.parsePositiveNumber("-1");
        });
        assertEquals("[ERROR] 양수만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 비숫자_입력시_예외발생() { //
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtil.parsePositiveNumber("abc1");
        });
        assertEquals("[ERROR] 유효한 정수를 입력해주세요.", exception.getMessage());
    }

    @Test
    void 정수_범위를_벗어날시_예외발생(){
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            NumberUtil.parsePositiveNumber("2147483648");
        });
        assertEquals("[ERROR] 유효한 정수를 입력해주세요.", exception.getMessage());
    }
}