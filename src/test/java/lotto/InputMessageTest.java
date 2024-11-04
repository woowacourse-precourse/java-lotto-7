package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.EnterWinningNumberValidation;
import lotto.validation.PurchaseAmountValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputMessageTest {
  private final EnterWinningNumberValidation validator = new EnterWinningNumberValidation();

  @Test
  void 로또_번호가_6자리가_안될때() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 로또_번호가_범위에_맞지않는_수_가있을시() {
    List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
    assertFalse(validator.validateEnterWinningNumber(invalidNumbers));
  }

  @Test
  void 로또_번호가_정상값_일때() {
    List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertThat(validator.validateEnterWinningNumber(invalidNumbers));
  }


}
