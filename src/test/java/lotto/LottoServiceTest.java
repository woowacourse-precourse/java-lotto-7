package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

  private final LottoService lottoService = new LottoService();

  @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
  @Test
  void 구입_금액이_1000원_단위가_아니면_예외_발생() {
    assertThatThrownBy(() -> lottoService.purchaseLotto(1500))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
  }

  @DisplayName("구입 금액에 맞는 로또 티켓 수량이 발행된다.")
  @Test
  void 구입_금액에_맞게_로또_티켓_발행() {
    List<LottoTicket> tickets = lottoService.purchaseLotto(5000); // 5,000원 -> 5장
    assertThat(tickets).hasSize(5);
  }
}
