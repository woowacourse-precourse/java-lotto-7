package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("인자로 음수가 오는 경우 예외로 처리합니다.")
    @Test
    void 인자로_음수가_오는_경우_예외처리() {
        Integer negativeAmount = -10;

        assertThrows(IllegalArgumentException.class, () ->
            Validator.validatePurchaseAmount(negativeAmount));
    }

    @DisplayName("인자로 오는 값이 1,000원 단위로 나누어 떨어지지 않는 경우 예외로 처리합니다.")
    @Test
    void 인자가_천원_단위로_떨어지지_않는_경우_예외처리() {
        Integer amount = 1010;

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validatePurchaseAmount(amount));
    }

    @DisplayName("인자로 오는 정수들중 중복되는 경우 예외로 처리합니다.")
    @Test
    void 인자로_서로_중복된_정수가_오는_경우_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,5);

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateWinningNumber(winningNumbers));
    }

    @DisplayName("로또 번호(1~45)에 해당하지 않는 숫자가 나온 경우 에외로 처리합니다.")
    @Test
    void 인자로_로또_번호가_아닌_숫자가_오는_경우_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,46);

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateWinningNumber(winningNumbers));
    }

    @DisplayName("인자로 로또 번호의 숫자 6자리를 벗어나는 크기의 리스트가 오는 경우 예외로 처리합니다.")
    @Test
    void _6자리_숫자를_벗어나는_경우_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6,7);

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateWinningNumber(winningNumbers));
    }

    @DisplayName("보너스 번호가 로또 번호(1~45)에 해당하지 않는 경우오는 경우 예외로 처리합니다.")
    @Test
    void 보너스_번호가_로또_번호_범위를_벗어나는_경우_예외처리() {
        Integer bonusNumber = 64;

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateBonusNumber(bonusNumber));
    }

    @DisplayName("보너스 번호가 음수인 경우 예외로 처리합니다.")
    @Test
    void 보너스_번호가_음수인_경우_예외처리() {
        Integer bonusNumber = -10;

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateBonusNumber(bonusNumber));
    }

    @DisplayName("당첨 번호의 내용과 보너스 번호가 서로 겹치는 경우")
    @Test
    void 당첨_번호와_보너스_번호가_중복되는_경우_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5);
        Integer bonusNumber = 4;

        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateBonusNumberInWinningNumber(winningNumbers, bonusNumber));
    }

}
