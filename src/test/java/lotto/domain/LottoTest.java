package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외 발생")
    public void testInvalidLottoSize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("로또 번호는 6개여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 1에서 45 사이가 아닌 경우 예외 발생")
    public void testInvalidLottoRange() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 46);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("로또 번호는 1에서 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외 발생")
    public void testLottoWithDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("로또 번호는 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호에 중복되는지 확인")
    public void testHasDuplicatedBonusNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertTrue(lotto.hasDuplicatedBonusNumber(3), "보너스 번호가 로또 번호에 중복되면 true를 반환해야 합니다.");
        assertFalse(lotto.hasDuplicatedBonusNumber(7), "보너스 번호가 로또 번호에 중복되지 않으면 false를 반환해야 합니다.");
    }

    @Test
    @DisplayName("사용자 로또 번호와 매칭되는 개수 확인")
    public void testMatching() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

        Lotto lotto = new Lotto(winningNumbers);
        int matchCount = lotto.matching(userNumbers);

        assertEquals(3, matchCount, "사용자 로또 번호와 매칭되는 개수는 3개여야 합니다.");
    }
}
