package lotto.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.model.Lotto;

public class LottoUtilsTest {
    @Test
    void 구분자로_문자열_분리() {
        String input = "1,2,3,4,5,6";
        String[] result = LottoUtils.splitInput(input);

        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, result);
    }

    @Test
    void 양수가_아닌_입력_예외_처리() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validatePositiveNumber("-1", "구입 금액"));
        assertEquals("[ERROR] 구입 금액 숫자로만 이루어진 양수여야 합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validatePositiveNumber("abc", "구입 금액"));
        assertEquals("[ERROR] 구입 금액 숫자로만 이루어진 양수여야 합니다.", exception.getMessage());
    }

    @Test
    void 번호개수가_6개가아니면_예외_처리() {
        String[] input = {"1", "2", "3", "4", "5"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validateInputNumbersCount(input, "당첨 번호"));
        assertEquals("[ERROR] 당첨 번호 6개여야 합니다.", exception.getMessage());
    }

    @Test
    void 범위_밖의_숫자_예외_처리() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validateNumberRange(0, "당첨 번호"));
        assertEquals("[ERROR] 당첨 번호 1와 45 사이여야 합니다.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> 
            LottoUtils.validateNumberRange(50, "당첨 번호"));
        assertEquals("[ERROR] 당첨 번호 1와 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    void 로또가_잘_생성되는지(){
        Lotto lotto = LottoUtils.createLotto();
        List<Integer> numbers = lotto.getLotto();
        
        assertEquals(6, lotto.getLotto().size());
                for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45); 
        }
    }
}
