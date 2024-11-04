package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputValidatorTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        int money = 11111;

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validatePurchaseAmount(money));
    }

    @Test
    @DisplayName("보너스 번호가 1미만 45를 초과하는 숫자이면 예외가 발생한다.")
    void 보너스_번호가_1미만_45를_초과하는_숫자이면_예외가_발생한다() {
        int bonus = 46;

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateBonusNumberRange(bonus));
    }

    @Test
    @DisplayName("보너스 번호가 로또 당첨 번호와 중복되는 값이 있으면 예외가 발생한다.")
    void 보너스_번호가_로또_당첨_번호와_중복되는_값이_있으면_예외가_발생한다() {
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int bonus = 6;

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.checkBonusNumberDuplicates(winningNumbers, bonus));
    }

}