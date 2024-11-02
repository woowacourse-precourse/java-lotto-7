package lotto;

import lotto.validator.InputValidator;
import lotto.validator.InputValidatorInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputTest {
  private InputValidatorInterface inputValidator;

  @BeforeEach
  void setUp() {
    inputValidator = new InputValidator();
  }

  @Test
  @DisplayName("유효하지 않은 로또 구입 금액이 입력되었을 때 예외를 던진다")
  void 유효하지_않은_로또_구입_금액이_입력되었을_때_예외를_던진다() {
    assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("1500"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("유효한 로또 구입 금액이 입력되었을 때 예외가 발생하지 않는다")
  void 유효한_로또_구입_금액이_입력되었을_때_예외가_발생하지_않는다() {
    assertThatNoException().isThrownBy(() -> inputValidator.validatePurchaseAmount("1000"));
  }

  @Test
  @DisplayName("당첨 번호가 6개 미만일 경우 예외를 던진다")
  void 당첨_번호가_6개_미만일_경우_예외를_던진다() {
    assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("당첨 번호가 1~45 범위를 벗어날 경우 예외를 던진다")
  void 당첨_번호가_범위를_벗어날_경우_예외를_던진다() {
    assertThatThrownBy(() -> inputValidator.validateWinningNumbers("0,2,3,4,5,6"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("중복된 보너스 번호가 입력될 경우 예외를 던진다")
  void 중복된_보너스_번호가_입력될_경우_예외를_던진다() {
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertThatThrownBy(() -> inputValidator.validateBonusNumber("6", winningNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("유효한 보너스 번호가 입력되었을 때 예외가 발생하지 않는다")
  void 유효한_보너스_번호가_입력되었을_때_예외가_발생하지_않는다() {
    List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    assertThatNoException().isThrownBy(() -> inputValidator.validateBonusNumber("7", winningNumbers));
  }
}
