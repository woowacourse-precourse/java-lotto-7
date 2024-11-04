package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import lotto.LottoWinningNumbers;
import lotto.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {
  @Test
  void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
    assertThatThrownBy(() -> new LottoWinningNumbers( new int[]{1, 2, 3, 4, 5, 6, 7} , 6))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void 구매할_금액이_1000으로_안_나누어지면_에러_발생() {
    assertThatThrownBy(() -> new PurchaseAmount(5112))
        .isInstanceOf(IllegalArgumentException.class);
  }
}

