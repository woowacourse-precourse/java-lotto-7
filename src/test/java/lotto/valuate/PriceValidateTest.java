package lotto.valuate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceValuateTest {

    @Test
    void isValidNumber_validNumber_doesNotThrowException() {
        // given
        String validInput = "5000";

        // when & then
        assertDoesNotThrow(() -> PriceValuate.isValidNumber(validInput),
                "정상적인 값이 예외를 발생시키고 있습니다.");
    }

    @Test
    void isValidNumber_invalidNumber_throwsException() {
        String invalidInput = "abc";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PriceValuate.isValidNumber(invalidInput),
                "예외를 발생시켜야 합니다.");

        assertEquals("금액은 숫자 형식으로 입력해주세요. ex) 5000", exception.getMessage());
    }

    @Test
    void isValidPrice_notThousandUnit_throwsException() {
        int invalidPrice = 5500;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PriceValuate.isValidPrice(invalidPrice),
                "1000원 단위로 입력하지 않으면 예외를 발생시켜야 합니다.");

        assertEquals("금액은 1000원 단위로 입력해 주세요.", exception.getMessage());
    }

    @Test
    void isValidPrice_lessThanThousand_throwsException() {
        int invalidPrice = 500;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> PriceValuate.isValidPrice(invalidPrice),
                "1000원 단위로 입력하지 않으면 예외를 발생시켜야 합니다.");

        assertEquals("금액은 1000원 단위로 입력해 주세요.", exception.getMessage());
    }
}
