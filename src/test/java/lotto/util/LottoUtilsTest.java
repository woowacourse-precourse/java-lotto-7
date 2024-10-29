package lotto.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LottoUtilsTest {
    @Test
    void splitInput_구분자로_문자열_분리() {
        String input = "1,2,3,4,5,6";
        String[] result = LottoUtils.splitInput(input);

        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, result);
    }

    @Test
    void validatePositiveNumber_양수인_숫자_유효성_검증_성공() {
        assertDoesNotThrow(() -> LottoUtils.validatePositiveNumber("123", "테스트 메시지"));
    }

    @Test
    void validatePositiveNumber_양수가_아닌_입력_예외_처리() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validatePositiveNumber("-1", "구입 금액"));
        assertEquals("[ERROR] 구입 금액 숫자로만 이루어진 양수여야 합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validatePositiveNumber("abc", "구입 금액"));
        assertEquals("[ERROR] 구입 금액 숫자로만 이루어진 양수여야 합니다.", exception.getMessage());
    }

    @Test
    void validateInputNumbersCount_정확한_개수_유효성_검증_성공() {
        String[] input = {"1", "2", "3", "4", "5", "6"};
        assertDoesNotThrow(() -> LottoUtils.validateInputNumbersCount(input, "당첨 번호"));
    }

    @Test
    void validateInputNumbersCount_개수가_다르면_예외_처리() {
        String[] input = {"1", "2", "3", "4", "5"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validateInputNumbersCount(input, "당첨 번호"));
        assertEquals("[ERROR] 당첨 번호 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void validateNumberRange_범위_내_숫자_유효성_검증_성공() {
        assertDoesNotThrow(() -> LottoUtils.validateNumberRange(10, "당첨 번호"));
    }

    @Test
    void validateNumberRange_범위_밖의_숫자_예외_처리() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validateNumberRange(0, "당첨 번호"));
        assertEquals("[ERROR] 당첨 번호 1와 45 사이여야 합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validateNumberRange(50, "당첨 번호"));
        assertEquals("[ERROR] 당첨 번호 1와 45 사이여야 합니다.", exception.getMessage());
    }
}
