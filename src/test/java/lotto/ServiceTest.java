package lotto;

import java.util.ArrayList;
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
  private List<Lotto> lottos;

  @BeforeEach
  void setUp() {
    lottosService = new LottoService();
    // 8개 로또 리스트
    lottos = new ArrayList<>();
    lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
    lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
    lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
    lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
    lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
    lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
    lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
    lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
  }

  @Test
  @DisplayName("로또를 생성하는 테스트")
  void 로또를_생성하는_테스트() {
    int purchaseAmount = 10000;
    List<Lotto> testLotto = lottosService.generateLottosByAmount(purchaseAmount);
    assertThat(testLotto).isNotEmpty(); // 생성된 로또가 비어 있지 않음을 확인합니다.
    assertThat(testLotto.size()).isEqualTo(10); // 10개의 로또가 생성되었는지 확인합니다.
  }

  @Test
  @DisplayName("당첨 결과 리스트 테스트")
  void 당첨_결과_리스트_테스트() {
    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    List<Integer> result = lottosService.checkWinningNumbers(lottos, winningNumbers, bonusNumber);

    assertThat(result).containsExactly(1, 0, 0, 0, 0);
  }

  @Test
  @DisplayName("당첨 결과 리스트 테스트 - 2등 로또 당첨")
  void 당첨_결과_리스트_테스트_2등() {
    List<Integer> winningNumbers = List.of(9, 21, 23, 41, 42, 43);
    int bonusNumber = 8;

    List<Integer> result = lottosService.checkWinningNumbers(lottos, winningNumbers, bonusNumber);

    assertThat(result).containsExactly(0, 0, 0, 1, 0);
  }

  @Test
  @DisplayName("수익률 테스트")
  void 수익률_테스트() {
    List<Integer> winningResults = List.of(1, 0, 0, 0, 0);
    int investmentAmount = 8000;

    double actualResult = lottosService.calculateYield(winningResults, investmentAmount);

    double expectResult = 62.5;

    assertThat(actualResult).isEqualTo(expectResult);
  }
}
