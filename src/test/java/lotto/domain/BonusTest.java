package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BonusTest {

    private Lotto winningLotto;

    @BeforeEach
    public void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11));
    }

    @Test
    @DisplayName("보너스 번호가 1에서 45 사이가 아닐 때 예외 발생")
    public void testBonusNumberOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new Bonus(46, winningLotto), "보너스 번호는 1~45 사이여야 합니다.");
        assertThrows(IllegalArgumentException.class, () -> new Bonus(0, winningLotto), "보너스 번호는 1~45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    public void testBonusNumberDuplicateWithWinningNumbers() {
        // 보너스 번호가 당첨 번호 중 하나와 같은 경우
        assertThrows(IllegalArgumentException.class, () -> new Bonus(3, winningLotto), "보너스 번호는 당첨 번호와 중복 될수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 올바른 범위에 있고 당첨 번호와 중복되지 않을 때 성공적으로 생성")
    public void testBonusNumberValid() {
        Bonus bonus = new Bonus(2, winningLotto);
        assertNotNull(bonus);
    }

    @Test
    @DisplayName("사용자의 로또 번호가 보너스 번호를 포함하는지 확인")
    public void testBonusMatching() {
        Bonus bonus = new Bonus(2, winningLotto);
        List<Integer> userLotto = Arrays.asList(2, 4, 6, 8, 10, 12);
        assertTrue(bonus.matching(userLotto));

        userLotto = Arrays.asList(13, 14, 15, 16, 17, 18);
        assertFalse(bonus.matching(userLotto));
    }
}
