package lotto.validation;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {

  @Test
  void 올바른_로또_번호가_입력되면_예외가_발생하지_않는다() {
    List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    assertThatCode(() -> LottoNumberValidator.validateLottoNumbers(validNumbers))
        .doesNotThrowAnyException();
  }

  @Test
  void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
    List<Integer> invalidQuantity = Arrays.asList(1, 2, 3, 4, 5);

    assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumbers(invalidQuantity))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_LOTTO_QUANTITY.getMessage());
  }

  @Test
  void 로또_번호에_범위를_벗어나는_숫자가_포함되면_예외가_발생한다() {
    List<Integer> outOfRangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 60);

    assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumbers(outOfRangeNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
  }

  @Test
  void 로또_번호에_중복된_숫자가_포함되면_예외가_발생한다() {
    List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

    assertThatThrownBy(() -> LottoNumberValidator.validateLottoNumbers(duplicateNumbers))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
  }
}
