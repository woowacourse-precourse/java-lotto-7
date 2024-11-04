package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
  @Test
  void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @MethodSource("invalidLottoNumbersProvider")
  void 당첨_번호가_1에서_45의_숫자가_아니면_예외를_발생시킨다(List<Integer> numbers) {
    assertThatThrownBy(() -> new Lotto(numbers, 7))
            .isInstanceOf(IllegalArgumentException.class);
  }

  static Stream<List<Integer>> invalidLottoNumbersProvider() {
    return Stream.of(
            List.of(1, 2, 3, 4, 5, 46),
            List.of(0, 2, 3, 4, 5, 6)
    );
  }

  @Test
  void 당첨_번호가_중복되면_예외를_발생시킨다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), 6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 보너스_번호가_당첨_번호와_중복되면_예외를_발생시킨다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void 보너스_번호가_1에서_45의_숫자가_아니면_예외를_발생시킨다(int bonus) {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), bonus))
            .isInstanceOf(IllegalArgumentException.class);
  }

}
