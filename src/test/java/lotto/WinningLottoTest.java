package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

  @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
  @Test
  void 보너스번호가_당첨번호와_중복되면_예외_발생() {
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int duplicateBonusNumber = 6;

    assertThatThrownBy(() -> new WinningLotto(winningNumbers, duplicateBonusNumber))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
  }

  @DisplayName("정상적인 당첨 번호와 보너스 번호를 설정한다.")
  @Test
  void 정상적인_당첨번호와_보너스번호_설정() {
    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    assertThat(winningLotto).isNotNull();
  }
}
