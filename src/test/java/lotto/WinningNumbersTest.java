package lotto;

import java.util.List;
import lotto.domain.service.ValidationService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumbersTest {

    @Test
    void 당첨번호가_중복되면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validateWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }

    @Test
    void 보너스번호가_범위를_벗어나면_예외_발생() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String invalidBonusNumber = "46"; // 범위 초과

        // 표현식 람다로 수정
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validateBonusNumber(invalidBonusNumber, winningNumbers));
    }
}