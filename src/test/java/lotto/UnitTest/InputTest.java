package lotto.UnitTest;

import lotto.View.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

  @Test
  @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
  void 구입_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
    assertThatThrownBy(() -> Input.validatePurchaseAmount(1500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
  }

  @Test
  @DisplayName("당첨 번호가 중복 없이 6개의 숫자가 아닐 경우 예외가 발생한다.")
  void 당첨_번호가_중복_없이_6개의_숫자가_아닐_경우_예외가_발생한다() {
    Set<Integer> duplicateNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 3, 4, 5));
    Set<Integer> insufficientNumbers = Set.of(1, 2, 3, 4, 5);

    assertThatThrownBy(() -> Input.validateWinningNumbers(duplicateNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 중복 없이 6개의 숫자로 입력해야 합니다.");

    assertThatThrownBy(() -> Input.validateWinningNumbers(insufficientNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 당첨 번호는 중복 없이 6개의 숫자로 입력해야 합니다.");
  }

  @Test
  @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
  void 보너스_번호가_당첨_번호와_중복될_경우_예외가_발생한다() {
    Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
    int duplicateBonusNumber = 5;

    assertThatThrownBy(() -> Input.validateBonusNumber(duplicateBonusNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
  }

  @Test
  @DisplayName("정상적인 구입 금액은 예외가 발생하지 않는다.")
  void 정상적인_구입_금액은_예외가_발생하지_않는다() {
    int validAmount = 8000;
    Input.validatePurchaseAmount(validAmount); // 예외가 발생하지 않아야 함
  }

  @Test
  @DisplayName("정상적인 당첨 번호는 예외가 발생하지 않는다.")
  void 정상적인_당첨_번호는_예외가_발생하지_않는다() {
    Set<Integer> validWinningNumbers = Set.of(1, 2, 3, 4, 5, 6);
    Input.validateWinningNumbers(validWinningNumbers); // 예외가 발생하지 않아야 함
  }

  @Test
  @DisplayName("보너스 번호가 당첨 번호와 중복되지 않을 경우 예외가 발생하지 않는다.")
  void 보너스_번호가_당첨_번호와_중복되지_않을_경우_예외가_발생하지_않는다() {
    Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
    int validBonusNumber = 7;

    Input.validateBonusNumber(validBonusNumber, winningNumbers); // 예외가 발생하지 않아야 함
  }
}
