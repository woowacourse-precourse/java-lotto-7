package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

  @DisplayName("로또 번호 리스트가 6개가 아니면 예외가 발생한다.")
  @Test
  void 로또번호_개수가_6개가_아니면_예외_발생() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void 로또번호에_중복이_있으면_예외_발생() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
  }
}
