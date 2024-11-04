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

    @DisplayName("당첨번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 당첨번호에_중복이_있으면_예외가_발생한다() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호의 개수는 6개여야 한다.")
    @Test
    void 당첨번호의_개수는_6개여야_한다() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨번호가 범위내에 없으면 에외를 발생한다.")
    @Test
    void 입력한_당첨번호가_범위내에_없으면_예외를_발생한다() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 60);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스번호가 범위내에 없으면 에외를 발생한다.")
    @Test
    void 보너스번호가_범위내에_없으면_예외를_발생한다() {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 60;
        assertThatThrownBy(() -> new Lottos(lottos, winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

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
