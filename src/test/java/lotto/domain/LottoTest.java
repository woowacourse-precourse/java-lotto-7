package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

  @Test
  void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(
        IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(
        IllegalArgumentException.class);
  }

  @DisplayName("정상적인 로또 번호로 객체를 생성한다")
  @Test
  void 정상적인_로또_번호로_객체를_생성한다() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(numbers);
    assertEquals(6, lotto.getNumbers().size());
    assertTrue(lotto.getNumbers().containsAll(numbers));
  }

  @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다")
  @Test
  void 로또_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
    List<Integer> numbers = List.of(0, 2, 3, 4, 5, 46);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new Lotto(numbers);
    });
    assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
  }
}
