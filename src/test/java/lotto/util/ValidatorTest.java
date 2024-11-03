package lotto.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void 구입_금액이_음수일_경우() {
        assertThrows(IllegalArgumentException.class, () -> Validator.purchaseAmount("-500"),
                "[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @Test
    void 구입_금액이_1000원_단위가_아닐_경우() {
        assertThrows(IllegalArgumentException.class, () -> Validator.purchaseAmount("1500"),
                "[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 구입_금액이_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> Validator.purchaseAmount("일이삼사"),
                "[ERROR] 숫자를 입력해 주세요.");
    }

    @Test
    void 구입_금액이_정상적인_경우() {
        Validator.purchaseAmount("2000");  // 예외가 발생하지 않으면 성공
    }
}