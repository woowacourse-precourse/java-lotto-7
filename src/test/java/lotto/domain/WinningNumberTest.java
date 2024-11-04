package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

  @DisplayName("정상적인 당첨 번호 입력 시 객체가 생성된다")
  @Test
  void 정상적인_당첨_번호_입력_시_객체가_생성된다() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    WinningNumber winningNumber = new WinningNumber(numbers);
    assertEquals(6, winningNumber.getNumbers().size());
    assertTrue(winningNumber.getNumbers().containsAll(numbers));
  }

  @DisplayName("당첨 번호 개수가 6개 미만이면 예외가 발생한다")
  @Test
  void 당첨_번호_개수가_6개_미만이면_예외가_발생한다() {
    List<Integer> numbers = List.of(1, 2, 3);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new WinningNumber(numbers);
    });
    assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
  }

  @DisplayName("당첨 번호 개수가 6개 초과이면 예외가 발생한다")
  @Test
  void 당첨_번호_개수가_6개_초과이면_예외가_발생한다() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new WinningNumber(numbers);
    });
    assertEquals("[ERROR] 로또 번호는 6개여야 합니다.", exception.getMessage());
  }

  @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다")
  @Test
  void 당첨_번호에_범위를_벗어난_숫자가_있으면_예외가_발생한다() {
    List<Integer> numbers = List.of(0, 46, 5, 10, 15, 20);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new WinningNumber(numbers);
    });
    assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
  }

  @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
  @Test
  void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
    List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new WinningNumber(numbers);
    });
    assertEquals("[ERROR] 로또 번호는 중복될 수 없습니다.", exception.getMessage());
  }
}
