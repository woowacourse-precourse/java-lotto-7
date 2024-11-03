package lotto.test;

import static lotto.constant.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.NOT_NUMBER_RANGE_BONUS_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.BonusNumber;
import lotto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("보너스 번호를 담는 BonusNumber에서")
public class BonusNumberTest {

    @Test
    @DisplayName("bonusNumber가 1~45 사이에 있으면 오류를 발생하지 않는다")
    public void normalBonusNumber() {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy(() -> new BonusNumber(5));
    }

    @Test
    @DisplayName("bonusNumber가 1~45 밖에 있으면 오류가 발생한다")
    public void notInRangeBonusNumber() {
        //given
        BonusNumber bonusNumber = new BonusNumber(50);
        //when
        //then
        Assertions.assertThatThrownBy(bonusNumber::validateBonusNumberInRange)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_RANGE_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("bonusNumber가 winning number들에 없는 숫자면 오류가 발생하지 않는다")
    public void notContainBonusNumberWinningNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        BonusNumber bonusNumber = new BonusNumber(7);
        //when
        //then
        Assertions.assertThatNoException()
                .isThrownBy(() -> bonusNumber.validateBonusNumberNotDuplicate(winningNumbers));
    }

    @Test
    @DisplayName("bonusNumber가 winning number들에 있는 숫자면 오류가 발생한다")
    public void containBonusNumberWinningNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        BonusNumber bonusNumber = new BonusNumber(5);
        //when
        //then
        Assertions.assertThatThrownBy(() -> bonusNumber.validateBonusNumberNotDuplicate(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_BONUS_NUMBER.getMessage());
    }
}
