package lotto.model;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.enums.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 번호 결과 테스트")
    @Test
    void 로또_번호_결과_테스트() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        Integer bonusNumber = 6;

        List<Lotto> testLottos = new ArrayList<>();
        Lotto lotto = new Lotto(lottoNumbers);
        testLottos.add(lotto);

        Lottos lottos = new Lottos(testLottos, winningNumbers, bonusNumber);
        Map<WinningType, Integer> winningResult = lottos.getWinningResult();

        Assertions.assertThat(winningResult.get(WinningType.FIVE_BONUS)).isEqualTo(1);
    }

    @DisplayName("로또 총 수익 테스트")
    @Test
    void 로또_총_수익_테스트() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        Integer bonusNumber = 6;

        List<Lotto> testLottos = new ArrayList<>();
        Lotto lotto = new Lotto(lottoNumbers);
        testLottos.add(lotto);

        Lottos lottos = new Lottos(testLottos, winningNumbers, bonusNumber);
        Map<WinningType, Integer> winningResult = lottos.getWinningResult();

        Assertions.assertThat(lottos.getTotalPrize()).isEqualTo(30000000);
    }
}
