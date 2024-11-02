package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.service.LottosServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class ServiceTest {

  private LottosServiceInterface lottosService;

  @BeforeEach
  void setUp() {
    lottosService = new LottoService();
  }

  @Test
  @DisplayName("로또를 생성하는 테스트")
  void generateLottosTest() {
    int purchaseAmount = 10000;
    List<Lotto> lottos = lottosService.generateLottosByAmount(purchaseAmount);
    assertThat(lottos).isNotEmpty(); // 생성된 로또가 비어 있지 않음을 확인합니다.
    assertThat(lottos.size()).isEqualTo(10); // 10개의 로또가 생성되었는지 확인합니다.
  }

}
