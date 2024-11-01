package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

  @DisplayName("정상적인 보너스 번호 입력 시 객체가 생성된다")
  @Test
  void 정상적인_보너스_번호_입력_시_객체가_생성된다() {
    WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
    assertEquals(7, bonusNumber.getNumber());
  }

  @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생한다")
  @Test
  void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
    WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new BonusNumber(46, winningNumber);
    });
    assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
  }

  @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
  @Test
  void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
    WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new BonusNumber(3, winningNumber);
    });
    assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
  }
}
