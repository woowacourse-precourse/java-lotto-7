package lotto.winning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.service.WinningService;
import lotto.validate.WinningValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @Test
    @DisplayName("숫자와 쉼표로 이루어진 문자열은 올바른 당첨 번호 문자열이다.")
    public void testValidWinningString() {
        String winningString = "1,2,3,4,5,6";

        assertTrue(WinningValidate.isValidString(winningString));
    }

    @Test
    @DisplayName("숫자와 쉼표로 이루어지지 않은 문자열은 올바르지 않은 당첨 번호 문자열이다.")
    public void testInvalidWinningString() {
        String winningString = "1,2, 3,4, ab,c!";

        assertFalse(WinningValidate.isValidString(winningString));
    }

    @Test
    @DisplayName("쉼표를 기준으로 잘려진 문자열의 크기가 6인 문자열은 올바른 당첨 번호 문자열이다.")
    public void testValidStringSize() {
        String winningString = "11,22,33,44,55,66";

        assertTrue(WinningValidate.isSixNumber(winningString));
    }

    @Test
    @DisplayName("쉼표를 기준으로 잘려진 문자열의 크기가 6이 아닌 문자열은 올바르지 않은 당첨 번호 문자열이다.")
    public void testInvalidStringSize() {
        String winningString = "1,2,3,4,5";

        assertFalse(WinningValidate.isSixNumber(winningString));
    }

    @Test
    @DisplayName("HashSet에 동일한 당첨 번호가 저장되어 있다.")
    public void testValidSetSize() {
        String winningString = "1,2,3,4,5,6";
        HashSet<Integer> winningSet = WinningService.addWinningNumber(winningString);
        HashSet<Integer> compareSet = new HashSet<>();

        compareSet.add(1);
        compareSet.add(2);
        compareSet.add(3);
        compareSet.add(4);
        compareSet.add(5);
        compareSet.add(6);

        assertEquals(compareSet, winningSet);
    }

    @Test
    @DisplayName("HashSet에 동일하지 않은 당첨 번호가 저장되어 있다.")
    public void testInvalidSetSize() {
        String winningString = "1,2,3,4,5,6";
        HashSet<Integer> winningSet = WinningService.addWinningNumber(winningString);
        HashSet<Integer> compareSet = new HashSet<>();

        compareSet.add(1);
        compareSet.add(2);
        compareSet.add(3);

        assertNotEquals(compareSet, winningSet);
    }

    @Test
    @DisplayName("숫자면 보너스 문자가 가능하다.")
    public void testIsNumericBonusString() {
        String bonusString = "10";

        assertTrue(WinningValidate.isNumeric(bonusString));
    }

    @Test
    @DisplayName("숫자가 아니면 보너스 문자가 불가능하다.")
    public void testIsNotNumericBonusString() {
        String bonusString = "bonus";

        assertFalse(WinningValidate.isNumeric(bonusString));
    }

    @Test
    @DisplayName("1~45 사이의 숫자라면 보너스 문자로 가능하다.")
    public void testIsRangeOfBonusNumber() {
        int bonusNumber = 10;

        assertTrue(WinningValidate.isLottoNumber(bonusNumber));
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아니라면 보너스 문자로 불가능하다.")
    public void testIsNotRangeOfBonusNumber() {
        int bonusNumber = 100;

        assertFalse(WinningValidate.isLottoNumber(bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 동일하지 않은 숫자는 보너스 숫자로 가능하다.")
    public void testIsBonusNotInWinning() {
        Winning winning = new Winning();
        HashSet<Integer> winningSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        winning.setHashSet(winningSet);

        int bonusNumber = 10;

        assertTrue(WinningValidate.isBonusNotInWinning(bonusNumber, winning));
    }

    @Test
    @DisplayName("당첨 번호와 동일한 숫자는 보너스 숫자로 불가능하다.")
    public void testIsBonusInWinning() {
        Winning winning = new Winning();
        HashSet<Integer> winningSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        winning.setHashSet(winningSet);

        int bonusNumber = 2;

        assertFalse(WinningValidate.isBonusNotInWinning(bonusNumber, winning));
    }

    @Test
    @DisplayName("당첨 번호와 동일한 숫자는 제거된다.")
    public void testRemoveWinningNumber() {
        Winning winning = new Winning();
        HashSet<Integer> winningSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        winning.setHashSet(winningSet);

        Lotto lotto = new Lotto(new LinkedList<>(Arrays.asList(1,2,3,4,5,6)));
        Lottos lottos = new Lottos();
        WinningService winningService = new WinningService(lottos, winning);

        WinningService.containsWinningNumber(lotto);

        assertEquals(0, lotto.getNumber().size());
    }

    @Test
    @DisplayName("당첨 번호와 동일하지 않은 숫자는 제거되지 않는다.")
    public void testNotRemoveWinningNumber() {
        Winning winning = new Winning();
        HashSet<Integer> winningSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        winning.setHashSet(winningSet);

        Lotto lotto = new Lotto(new LinkedList<>(Arrays.asList(7,8,9,10,11,12)));
        Lottos lottos = new Lottos();
        WinningService winningService = new WinningService(lottos, winning);

        WinningService.containsWinningNumber(lotto);

        assertEquals(6, lotto.getNumber().size());
    }
}
