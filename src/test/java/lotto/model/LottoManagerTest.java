package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.model.LottoManager;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

  @Test
  void 구매금액이_1000원_미만일_경우_예외를_던진다() {
    // given
    int price = 500;
    // when
    assertThatThrownBy(() -> new LottoManager(price))
            // then
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 구매 금액은 1000원 이상이어야 합니다.");
  }

  @Test
  void 구매금액이_1000원_단위가_아닐_경우_예외를_던진다() {
    // given
    int price = 1500;
    // when
    assertThatThrownBy(() -> new LottoManager(price))
            // then
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 구매 금액은 1000원 단위로만 가능합니다.");
  }

  @Test
  void 구매금액이_2000원일_때_로또를_2개_생성한다() {
    // given
    int price = 2000;
    // when
    LottoManager lottoManager = new LottoManager(price);
    // then
    assertThat(lottoManager.generateLottos().size()).isEqualTo(2);
  }
}
