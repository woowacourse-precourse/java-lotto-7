package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LottoNumberTest {

    @Test
    public void testPickRandomNumbers() {
        List<Integer> numbers = LottoNumber.pickRandomNumbers(6);
        assertEquals(6, numbers.size());
        numbers.forEach(number -> assertTrue(number >= LottoNumber.MIN_NUMBER && number <= LottoNumber.MAX_NUMBER));
    }

    @Test
    public void testValidateNumberRange_Valid() {
        assertDoesNotThrow(() -> LottoNumber.validateNumberRange(10));
    }

    @Test
    public void testValidateNumberRange_Invalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.validateNumberRange(50);
        });
        assertEquals("[ERROR] 1~45사이의 숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    public void testValidateDuplicated_Valid() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertDoesNotThrow(() -> LottoNumber.validateDuplicated(numbers, 6));
    }

    @Test
    public void testValidateDuplicated_Invalid() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.validateDuplicated(numbers, 3);
        });
        assertEquals("[ERROR] 중복된 공입니다.", exception.getMessage());
    }
}