package lotto;

import static lotto.Application.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest2 {
    private static final int LOTTO_PRICE = 1000;

    @Test
    void testCalculateLottoCount() {
        assertEquals(8, calculateLottoCount(8000));
        assertEquals(1, calculateLottoCount(1000));
    }

    @Test
    void testValidateAmountValue() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> validateAmountValue("-1"));
        assertEquals("[ERROR] 구입 금액은 양수여야 합니다", thrown.getMessage());
    }

    @Test
    void testValidateAmountValue2() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> validateAmountValue("1234"));
        assertEquals("[ERROR] 구입 금액은 " + LOTTO_PRICE + "으로 나누어 떨어져야 합니다.", thrown.getMessage());
    }

    @Test
    void testValidateAmountValue3() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> validateAmountValue("abab"));
        assertEquals("[ERROR] 잘못된 입력입니다.", thrown.getMessage());
    }

    @Test
    void testValidateBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        assertThrows(IllegalArgumentException.class, () -> Application.validateBonusNumber("5", winningNumbers), "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        assertThrows(IllegalArgumentException.class, () -> Application.validateBonusNumber("abc", winningNumbers), "[ERROR] 올바르지 않은 타입입니다");
    }

    @Test
    void testGetMatchCount() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(3, getMatchCount(lottoNumbers, winningNumbers));
    }

    @Test
    void testRankValueOf() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.NONE, Rank.valueOf(2, false));
    }
}