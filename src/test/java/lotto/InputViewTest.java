package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Messages.ErrorMessage;
import lotto.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest extends NsTest {
    InputView inputView = new InputView();

    @Test
    public void testParseInt() {
        assertThrows(IllegalArgumentException.class, () -> InputView.parseInt("abc"));
        assertEquals(123, InputView.parseInt("123"));
    }

    @Test
    @DisplayName("parseInt 정상 작동 테스트")
    void parseIntTest() {
        int actual = inputView.parseInt("123");
        assertThat(actual).isEqualTo(123);
    }

    @Test
    @DisplayName("parseInt 숫자가 아닌 것 테스트")
    void parseIntErrorTest() {
        assertThatThrownBy(() -> inputView.parseInt("123a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMBER.getError());
    }

    @Test
    @DisplayName("checkBonus 정상 작동 테스트")
    void checkBonusTest() {
        int bonusNumber = 7;
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatNoException().isThrownBy(() -> inputView.checkBonus(bonusNumber, answer));
    }

    @Test
    @DisplayName("checkBonus 당첨 번호와 보너스 번호가 중복될 때")
    void checkBonusDuplicateTest() {
        int bonusNumber = 6;
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> inputView.checkBonus(bonusNumber, answer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_DUPLICATE.getError());
    }

    @Test
    @DisplayName("checkBonusRange 정상 작동 테스트")
    void checkBonusRangeTest() {
        int bonusNumber = 6;
        assertThatNoException().isThrownBy(() -> inputView.checkBonusRange(bonusNumber));
    }

    @Test
    @DisplayName("checkBonusRange 범위를 넘는 것 입력 시")
    void checkBonusRangeErrorTest() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> inputView.checkBonusRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_RANGE.getError());
    }

    @Test
    @DisplayName("checkRangeListTest 정상 범위 테스트")
    void checkRangeListTest() {
        boolean isInRange = true;
        assertThat(isInRange).isEqualTo(InputView.checkRangeList(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("checkRangeListTest 범위 벗어난 테스트")
    void checkRangeListTest2() {
        boolean isInRange = true;
        assertThat(!isInRange).isEqualTo(InputView.checkRangeList(List.of(1, 2, 3, 4, 5, 66)));
    }

    @Test
    @DisplayName("checkPurchaseRangeTest 정상 작동 테스트")
    void checkPurchaseRangeTest() {
        int purchaseAmount = 1000;
        assertThatNoException().isThrownBy(() -> inputView.checkPurchaseRange(purchaseAmount));
    }

    @ParameterizedTest
    @DisplayName("checkPurchaseRangeTest 범위 벗어난 테스트")
    @ValueSource(ints = {2000000010})
    void checkPurchaseRangeErrorTest(int purchaseAmount) {
        assertThatThrownBy(() -> inputView.checkPurchaseRange(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_RANGE.getError());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
